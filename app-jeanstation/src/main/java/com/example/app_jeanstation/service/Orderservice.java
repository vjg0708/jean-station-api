package com.example.app_jeanstation.service;

import com.example.app_jeanstation.DTO.OrderDTO;
import com.example.app_jeanstation.mapper.OrderMapper;
import com.example.app_jeanstation.model.Order;
import com.example.app_jeanstation.model.Product;
import com.example.app_jeanstation.repository.OrderRepository;
import com.example.app_jeanstation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class Orderservice {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductRepository productRepository;

	@Transactional
	public Order placeOrder(OrderDTO orderDTO) {
		// Fetch the product using the productCode from the database
		Product product = productRepository.findByProductCode(orderDTO.getProductCode())
				.orElseThrow(() -> new RuntimeException("Product not found with code: " + orderDTO.getProductCode()));

		// Check if enough stock is available
		if (product.getProductStock() < orderDTO.getQuantity()) {
			throw new RuntimeException("Not enough stock available for product: " + product.getProductName());
		}
		product.setProductStock(product.getProductStock() - orderDTO.getQuantity());
		productRepository.save(product);
		Order order = OrderMapper.convertToEntity(orderDTO, product);
		return orderRepository.save(order);
	}

	public List<OrderDTO> getAllOrders() {
		List<Order> orders = orderRepository.findAll();
		return OrderMapper.convertToDTOs(orders);
	}

	public Order releaseOrder(Long id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
		order.setStatus(Order.OrderStatus.RELEASED);

		return order;
	}

	public Order deleteFromCart(Long id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
		Product product = productRepository.findById(order.getProduct().getId())
				.orElseThrow(() -> new RuntimeException("Product Not Found"));
		product.setProductStock(product.getProductStock()+order.getQuantity());
		order.setProduct(productRepository.save(product));
		orderRepository.delete(order);
		return order;
	}
}
