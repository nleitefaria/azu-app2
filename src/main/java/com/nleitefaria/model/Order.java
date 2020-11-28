package com.nleitefaria.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_ORDER")
public class Order 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String buyerEmail;
	
	private Date orderTime;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Product> products;
	
	public Order() {
		super();
	}

	public Order(String buyerEmail, Date orderTime, List<Product> products) {
		super();
		this.buyerEmail = buyerEmail;
		this.orderTime = orderTime;
		this.products = products;
	}

	public Order(Integer id, String buyerEmail, Date orderTime, List<Product> products) {
		super();
		this.id = id;
		this.buyerEmail = buyerEmail;
		this.orderTime = orderTime;
		this.products = products;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}