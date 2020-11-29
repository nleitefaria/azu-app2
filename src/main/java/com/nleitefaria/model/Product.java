package com.nleitefaria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUCT")
public class Product 
{	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;
	
	@Column(unique = true)
	private String sku ;
	
	private String name;
	
    private Double price;
    
    private Date creationDate;
    
	public Product() {
		super();
	}
	
	public Product(String sku, String name, Double price, Date creationDate) {
		super();
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.creationDate = creationDate;
	}

	public Product(Integer id, String sku, String name, Double price, Date creationDate) {
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