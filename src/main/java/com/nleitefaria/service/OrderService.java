package com.nleitefaria.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nleitefaria.domain.OrderDTO;
import com.nleitefaria.domain.ProductDTO;
import com.nleitefaria.model.Order;
import com.nleitefaria.model.Product;
import com.nleitefaria.repository.OrderRepository;
import com.nleitefaria.repository.ProductRepository;

@Service
public class OrderService 
{
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public List<OrderDTO> findAll() 
	{
		List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		double totalAmount=0;
		for(Order order : orderRepository.findAll())
		{
			for(Product product : order.getProducts())
			{
				productDTOList.add(new ProductDTO(product.getId(), product.getSku(), product.getName(), product.getPrice(), product.getCreationDate()));
				totalAmount = totalAmount + product.getPrice();
			}		
			OrderDTO orderDTO = new OrderDTO(order.getBuyerEmail(), order.getOrderTime(), productDTOList, totalAmount);	
			orderDTOList.add(orderDTO);
		}			
		return orderDTOList;
	}
	
	public List<OrderDTO> findAll(String from, String to) throws ParseException 
	{
		List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		double totalAmount=0;
		for(Order order : orderRepository.findAllFromTo(new SimpleDateFormat("yyyy-MM-dd").parse(from), new SimpleDateFormat("yyyy-MM-dd").parse(to)))
		{
			for(Product product : order.getProducts())
			{
				productDTOList.add(new ProductDTO(product.getId(), product.getSku(), product.getName(), product.getPrice(), product.getCreationDate()));
				totalAmount = totalAmount + product.getPrice();
			}		
			OrderDTO orderDTO = new OrderDTO(order.getBuyerEmail(), order.getOrderTime(), productDTOList, totalAmount);	
			orderDTOList.add(orderDTO);
		}			
		return orderDTOList;
	}
		
	@Transactional
	public Order save(OrderDTO orderDTO)
	{
		List<Product> productList = new ArrayList<Product>();		
		for(ProductDTO productDTO : orderDTO.getProducts())
		{
			if(productDTO.getSku().equals(productRepository.findBySku(productDTO.getSku()).getSku()) == true)
			{
				productRepository.delete(productRepository.findBySku(productDTO.getSku()));					
			}
			
			productList.add(new Product(productDTO.getSku(), productDTO.getName(), productDTO.getPrice(), productDTO.getCreationDate()));				
		}
		Order order = new Order(orderDTO.getBuyerEmail(), orderDTO.getOrderTime(), productList);
		return orderRepository.save(order);
	}
}
