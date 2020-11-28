package com.nleitefaria.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nleitefaria.domain.OrderDTO;
import com.nleitefaria.model.Order;
import com.nleitefaria.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;

@Api(value = "OrderController", description = "REST endpoint related to Orders")
@RestController
public class OrderController 
{
	@Autowired
	OrderService orderService;
	
	@Operation(summary = "Get all orders")
	@GetMapping("/api/v1/orders")
	public ResponseEntity<List<OrderDTO>> findAll()
	{
		return new ResponseEntity<List<OrderDTO>>(orderService.findAll(), HttpStatus.OK);	
	}
	
	@Operation(summary = "Get all orders within a given time period")
	@GetMapping("/api/v1/orders/{from}/{to}")
	public ResponseEntity<List<OrderDTO>> findAllFromTo(@PathVariable String from, @PathVariable String to) throws ParseException
	{	
		return new ResponseEntity<List<OrderDTO>>(orderService.findAll(from, to), HttpStatus.OK);		
	}
	
	@Operation(summary = "Place a order")
	@PostMapping("/api/v1/order")
	public ResponseEntity<Order> save(@RequestBody OrderDTO orderDTO) 
	{
		Order order = orderService.save(orderDTO);		
		if(order != null)
		{
			return new ResponseEntity<Order>(orderService.save(orderDTO), HttpStatus.CREATED);		
		}
		else
		{
			return new ResponseEntity<Order>(orderService.save(orderDTO), HttpStatus.BAD_REQUEST);
		}	  
	}
}
