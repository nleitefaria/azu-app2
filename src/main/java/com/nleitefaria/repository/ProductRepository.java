package com.nleitefaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nleitefaria.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	Product findBySku(String sku);

}
