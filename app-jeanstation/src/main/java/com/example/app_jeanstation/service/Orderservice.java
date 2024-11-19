package com.example.app_jeanstation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app_jeanstation.model.Order;
import com.example.app_jeanstation.model.Product;
import com.example.app_jeanstation.repository.OrderRepo;
import com.example.app_jeanstation.repository.ProductRepository;

@Service
public class Orderservice {

	@Autowired
	OrderRepo orderRepo;
	ProductRepository productRepo;
	
	public List<Order> getallOrders()
	{
		return orderRepo.findAll();
	}
	
	public Order placeOrder(Order order)
	{
		Product product=productRepo.findById(order.getProduct().getProductId()).orElseThrow(() -> new RuntimeException("product not found"));
		if(product.getstock()<order.getQuantity())
		{
			throw new RuntimeException( "Products are insufficient");
		}
		
		product.setquantity(product.getstock()-order.getQuantity());
		productRepo.save(product);
		order.setStatus(Order.getOrderStatus.PLACED);
		
		return orderRepo.save(order);
	}
	
	public Order releaseorder(Long order_ID) 
	{
		Order order = orderRepo.findById(order_ID).orElseThrow(() -> new RuntimeException("Order not found") );
		order.setStatus(Order.getOrderStatus.RELEASED);
		return orderRepo.save(order);
	}
}
