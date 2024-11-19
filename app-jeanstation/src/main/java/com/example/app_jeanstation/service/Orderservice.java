package com.example.app_jeanstation.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.app_jeanstation.DTO.OrderDTO;
import com.example.app_jeanstation.DTO.ProductDTO;
import com.example.app_jeanstation.mapper.OrderMapper;
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
	
	public List<OrderDTO> getallOrders()
	{
		return orderRepo.findAll().stream().map(OrderMapper::convertToDTO).collect(Collectors.toList());
	}
	
	public Order placeOrder(OrderDTO order)
	{
		Product product=productRepo.findById(order.getProductId()).orElseThrow(() -> new RuntimeException("product not found"));
		if(product.getProductStock()< order.getQuantity())
		{
			throw new RuntimeException( "Products are insufficient");
		}
		
		product.setProductStock(product.getProductStock()-order.getQuantity());
		productRepo.save(product);
		order.setStatus(Order.getOrderStatus.PLACED.name());
		
		return orderRepo.save(OrderMapper.convertToEntity(order,product));
	}
	
	public Order releaseorder(Long order_ID) 
	{
		Order order = orderRepo.findById(order_ID).orElseThrow(() -> new RuntimeException("Order not found") );
		order.setStatus(Order.getOrderStatus.RELEASED);
		return orderRepo.save(order);
	}

	public Order deletefromcart(Long order_ID)
	{
		Order order = orderRepo.findById(order_ID).orElseThrow(() -> new RuntimeException("Order not found") );
		Product product=productRepo.findById(order.getProduct().getProductId()).orElseThrow(()->new RuntimeException("Product Not found"));
		product.setProductStock(product.getProductStock()+order.getQuantity());
		productRepo.save(product);
		orderRepo.deleteById(order_ID);
		return order;
	}
}
