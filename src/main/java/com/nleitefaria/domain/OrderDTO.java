package com.nleitefaria.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String buyerEmail;
	private Date orderTime;
	private List<ProductDTO> products;
	private double totalAmount;
	
	public OrderDTO() {
		super();
	}
	
	public OrderDTO(String buyerEmail, Date orderTime, List<ProductDTO> products, double totalAmount) {
		super();		
		this.buyerEmail = buyerEmail;
		this.orderTime = orderTime;
		this.products = products;
		this.totalAmount = totalAmount;
	}

	public OrderDTO(Integer id, String buyerEmail, Date orderTime, List<ProductDTO> products, double totalAmount) {
		super();
		this.id = id;
		this.buyerEmail = buyerEmail;
		this.orderTime = orderTime;
		this.products = products;
		this.totalAmount = totalAmount;
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

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}	
}