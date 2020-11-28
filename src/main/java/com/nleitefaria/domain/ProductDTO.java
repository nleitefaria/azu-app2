package com.nleitefaria.domain;

import java.io.Serializable;
import java.util.Date;

public class ProductDTO implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String sku ;
	private String name;
    private Double price;
    private Date creationDate;
    
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(String sku, String name, Double price) {
		super();
		this.sku = sku;
		this.name = name;
		this.price = price;
	}
	
	public ProductDTO(String sku, String name, Double price, Date creationDate) {
		super();
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.creationDate = creationDate;
	}

	public ProductDTO(Integer id, String sku, String name, Double price, Date creationDate) {
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.creationDate = creationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
