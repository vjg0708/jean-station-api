package com.example.app_jeanstation.controller;

import com.example.app_jeanstation.DTO.OrderDTO;
import com.example.app_jeanstation.service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import com.example.app_jeanstation.model.Order;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("api/jean-station")
public class OrderController {

	@Autowired
	Orderservice orderservice;

	@Secured("ROLE_USER")
	@GetMapping("/allorders")
//	@PreAuthorize("hasRole('USER')")  // Only Admin can view all orders
	public List<OrderDTO> getAllOrders() {
		return orderservice.getAllOrders();
	}

	@Secured("ROLE_USER")
	@PostMapping("/placeorder")
	@Transactional
//	@PreAuthorize("hasRole('USER')")  // Only User can place orders
	public String placeOrder(@RequestBody OrderDTO orderDTO) {
		return orderservice.placeOrder(orderDTO);
	}

	@Secured("ROLE_USER")
	@PutMapping("/{id}/release")
//	@PreAuthorize("hasRole('ADMIN')")  // Only Admin can release orders
	public Order releaseOrder(@PathVariable Long id,OrderDTO orderDTO) {

		orderDTO.setStatus(Order.OrderStatus.RELEASED);
		return orderservice.releaseOrder(id);
	}

	@Secured("ROLE_USER")
	@DeleteMapping("/{id}/deleteOrder")
//	@PreAuthorize("hasRole('USER')")  // Only User can delete orders
	public String deleteOrder(@PathVariable Long id) {
		return orderservice.deleteFromCart(id);
	}
}
