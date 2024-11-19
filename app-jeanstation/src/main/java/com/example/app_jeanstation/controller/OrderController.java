package com.example.app_jeanstation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app_jeanstation.model.Order;
import com.example.app_jeanstation.service.Orderservice;

@RestController
@RequestMapping("api/order")
public class OrderController {

	@Autowired
	 Orderservice orderservice;
	
	@GetMapping
	public List<Order> getAllOrders()
	{
		return orderservice.getallOrders();
	}
	
	@PostMapping
	public Order placeOrder(@RequestBody Order order) {
		return orderservice.placeOrder(order);
	}
	@PutMapping("/{id}/release")
	public Order releaseorder(@PathVariable Long id)
	{
		return orderservice.releaseorder(id);
	}
	
}
