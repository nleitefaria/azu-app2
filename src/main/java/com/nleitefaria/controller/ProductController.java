package com.nleitefaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nleitefaria.domain.ProductDTO;
import com.nleitefaria.model.Product;
import com.nleitefaria.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;

@Api(value = "ProductController", description = "REST endpoint related to Products")
@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Operation(summary = "Get all products")
	@GetMapping("/api/v1/products")
	public ResponseEntity<List<ProductDTO>> findAll()
	{
		return new ResponseEntity<List<ProductDTO>>(productService.findAll(), HttpStatus.OK);	
	}
	
	@Operation(summary = "Create a product")
	@PostMapping("/api/v1/product")
	public ResponseEntity<Product> save(@RequestBody ProductDTO productDTO) 
	{
		Product product = productService.save(productDTO);		
		if(product != null)
		{
			return new ResponseEntity<Product>(productService.save(productDTO), HttpStatus.CREATED);		
		}
		else
		{
			return new ResponseEntity<Product>(productService.save(productDTO), HttpStatus.BAD_REQUEST);
		}	  
	}
	
	@Operation(summary = "Delete a product")
	@DeleteMapping("/api/v1/product/{sku}")
	public ResponseEntity<String> delete(@PathVariable String sku) 
	{
		try 
		{
			productService.deleteBySku(sku);
			return new ResponseEntity<String>("Product successfully deleted",HttpStatus.OK);
		}
		catch (Exception e) 
		{
			return new ResponseEntity<String>("An exception occurred", HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(summary = "Update a product")
	@PutMapping("/api/v1/product/{sku}")
	public ResponseEntity<String> update(@PathVariable String sku, @RequestBody ProductDTO productDTO) 
	{
		try 
		{
			productService.updateBySku(sku, productDTO);
			return new ResponseEntity<String>("Product successfully update", HttpStatus.OK);
		}
		catch (Exception e) 
		{
			return new ResponseEntity<String>("An exception occurred", HttpStatus.BAD_REQUEST);
		}
	}
}
