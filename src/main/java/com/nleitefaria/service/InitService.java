package com.nleitefaria.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nleitefaria.domain.ProductDTO;

@Service
public class InitService 
{
	@Autowired
	ProductService productService;
	
	public void init() 
	{
		clearDB();
		initProducts();	
	}
	
	private void clearDB()
	{
		productService.deleteAll();
	}
	
	private void initProducts()
	{
		ProductDTO product1 = new ProductDTO("A1B2011", "Keyboard", 7.99, new Date());
		ProductDTO product2 = new ProductDTO("B1B2011", "Television", 351.96, new Date());
		ProductDTO product3 = new ProductDTO("C1B2011", "Shirt", 3.57, new Date());
		ProductDTO product4 = new ProductDTO("D1B2011", "Bed", 131.00, new Date());
		ProductDTO product5 = new ProductDTO("E1B2011", "Cell Phone", 1000.00, new Date());
		ProductDTO product6 = new ProductDTO("F1B2011", "Spoon", 1.00, new Date());

		productService.save(product1);
		productService.save(product2);
		productService.save(product3);
		productService.save(product4);
		productService.save(product5);
		productService.save(product6);	
	}
}
