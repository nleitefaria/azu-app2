package com.nleitefaria.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nleitefaria.domain.ProductDTO;
import com.nleitefaria.model.Product;
import com.nleitefaria.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	ProductRepository productRepository;
	
	public ProductDTO findBySku(String sku)
	{
		Product product = productRepository.findBySku(sku);	
		return new ProductDTO(product.getSku(), product.getName(), product.getPrice());
	}
	
	public List<ProductDTO> findAll() 
	{
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();		
		for(Product product : productRepository.findAll())
		{
			ProductDTO productDTO = new ProductDTO(product.getId(), product.getSku(), product.getName(), product.getPrice(), product.getCreationDate());			
			productDTOList.add(productDTO);
		}			
		return productDTOList;
	}
	
	public Product findProductById(Integer id)
	{
		return productRepository.findById(id).get();		
	}
	
	public Product findProductBySku(String sku)
	{
		return productRepository.findBySku(sku);		
	}
	
	@Transactional
	public ProductDTO save(ProductDTO productDTO)
	{
		Product product = new Product(productDTO.getSku(), productDTO.getName(), productDTO.getPrice(), productDTO.getCreationDate());
		productRepository.save(product);
		return productDTO;
	}

	@Transactional
	public void deleteById(Integer id) 
	{
		Product product = findProductById(id);
		productRepository.delete(product);		
	}

	@Transactional
	public void deleteBySku(String sku) 
	{
		Product product = findProductBySku(sku);
		productRepository.delete(product);
	}

	@Transactional
	public void updateBySku(String sku, ProductDTO productDTO) 
	{
		Product product = findProductBySku(sku);
		if(productDTO.getSku() != null)
		{
			product.setSku(productDTO.getSku());			
		}	
		if(productDTO.getName() != null)
		{
			product.setName(productDTO.getName());			
		}
		if(productDTO.getPrice() != null)
		{
			product.setPrice(productDTO.getPrice());			
		}
		if(productDTO.getCreationDate() != null)
		{
			product.setCreationDate(productDTO.getCreationDate());			
		}
		productRepository.save(product);	
	}

	@Transactional
	public void deleteAll() {
		productRepository.deleteAll();
	}	
}
