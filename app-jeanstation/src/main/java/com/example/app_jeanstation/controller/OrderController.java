package com.example.app_jeanstation.controller;

import com.example.app_jeanstation.DTO.OrderDTO;
import com.example.app_jeanstation.service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.app_jeanstation.model.Order;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("api/jean-station")
public class OrderController {

	@Autowired
	Orderservice orderservice;

	@GetMapping("/allorders")
	public List<OrderDTO> getAllOrders() {
		return orderservice.getAllOrders();
	}

	@PostMapping("/placeorder")
	@Transactional  // Ensure this operation is transactional (order placement)
	public Order placeOrder(@RequestBody OrderDTO orderDTO) {
		// Validate product and quantity, ensure product exists in stock, etc.
		return orderservice.placeOrder(orderDTO);
	}

	@PutMapping("/{id}/release")
	public Order releaseOrder(@PathVariable Long id) {
		return orderservice.releaseOrder(id);
	}

	@DeleteMapping("/{id}/deleteorder")
	public Order deleteOrder(@PathVariable Long id) {
		return orderservice.deleteFromCart(id);
	}
}
