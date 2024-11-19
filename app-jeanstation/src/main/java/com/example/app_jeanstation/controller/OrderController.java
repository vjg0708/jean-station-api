package com.example.app_jeanstation.controller;

import java.util.List;

import com.example.app_jeanstation.DTO.OrderDTO;
import com.example.app_jeanstation.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.app_jeanstation.model.Order;
import com.example.app_jeanstation.service.Orderservice;

@RestController
@RequestMapping("api/order")
public class OrderController {

	@Autowired
	 Orderservice orderservice;
	ProductServiceImp productservice;
	
	@GetMapping("/allorders")
	public List<OrderDTO> getAllOrders()
	{
		return orderservice.getallOrders();
	}
	
	@PostMapping("/placeorder")
	public Order placeOrder(@RequestBody OrderDTO order) {
		return orderservice.placeOrder(order);
	}

	@PutMapping("/{id}/release")
	public Order releaseorder(@PathVariable Long id)
	{
		return orderservice.releaseorder(id);
	}

	@DeleteMapping("/{id}/deleteorder")
	public Order deleteOrder(@PathVariable Long id)
	{
		return orderservice.deletefromcart(id);
	}
}
