package com.example.app_jeanstation.mapper;

import com.example.app_jeanstation.DTO.OrderDTO;
import com.example.app_jeanstation.DTO.ProductDTO;
import com.example.app_jeanstation.model.Order;
import com.example.app_jeanstation.model.Product;

import java.util.List;
import java.util.stream.Collectors;



import com.example.app_jeanstation.DTO.OrderDTO;
import com.example.app_jeanstation.model.Order;
import com.example.app_jeanstation.model.Product;

public class OrderMapper {

    // Convert Order entity to OrderDTO
    public static OrderDTO convertToDTO(Order order) {
        return OrderDTO.builder()
                .orderId(order.getOrder_ID())
                .productId(order.getProduct().getProductId()) // Assuming Product has getProduct_ID()
                .quantity(order.getQuantity())
                .status(order.getStatus().name())
                .build();
    }

    // Convert OrderDTO to Order entity
    public static Order convertToEntity(OrderDTO orderDTO, Product product) {
        return Order.builder()
                .order_ID(orderDTO.getOrderId())
                .product(product) // Pass the Product entity
                .quantity(orderDTO.getQuantity())
                .status(Order.getOrderStatus.valueOf(orderDTO.getStatus()))
                .build();
    }

    public static List<OrderDTO> convertToDTOs(List<Order> orders){

        return orders.stream()
                .map(OrderMapper::convertToDTO)
                .collect(Collectors.toList());

    }

    public static List<Order> convertToEntities(List<OrderDTO> orderDTOs, List<Product> products) {
        return orderDTOs.stream()
                .map(orderDTO -> {
                    Product product = products.stream()
                            .filter(p -> p.getProductId().equals(orderDTO.getProductId()))
                            .findFirst()
                            .orElse(null); // Handle case where product is not found
                    return convertToEntity(orderDTO, product); // Use the single DTO-to-entity method
                })
                .collect(Collectors.toList());
    }
}
