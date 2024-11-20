package com.example.app_jeanstation.mapper;

import com.example.app_jeanstation.DTO.OrderDTO;
import com.example.app_jeanstation.model.Order;
import com.example.app_jeanstation.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    // Convert Order entity to OrderDTO
    public static OrderDTO convertToDTO(Order order) {
        return OrderDTO.builder()
                .orderId(order.getOrder_ID())
                .productCode(order.getProduct().getProductCode()) // Mapping productCode
                .quantity(order.getQuantity())
                .status(order.getStatus())
                .build();
    }

    // Convert OrderDTO to Order entity
    public static Order convertToEntity(OrderDTO orderDTO, Product product) {
        return Order.builder()
                .order_ID(orderDTO.getOrderId())
                .product(product) // Set the actual Product entity
                .quantity(orderDTO.getQuantity())
                .status(Order.OrderStatus.valueOf(orderDTO.getStatus().name())) // OrderStatus enum
                .build();
    }

    public static List<OrderDTO> convertToDTOs(List<Order> orders) {
        return orders.stream()
                .map(OrderMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    public static List<Order> convertToEntities(List<OrderDTO> orderDTOs, List<Product> products) {
        return orderDTOs.stream()
                .map(orderDTO -> {
                    Product product = products.stream()
                            .filter(p -> p.getProductCode().equals(orderDTO.getProductCode()))
                            .findFirst()
                            .orElse(null);
                    return convertToEntity(orderDTO, product);
                })
                .collect(Collectors.toList());
    }
}
