package com.example.app_jeanstation.DTO;

import com.example.app_jeanstation.model.Order.OrderStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {

    private Long orderId;
    private String productCode;
    private Integer quantity;
    private OrderStatus status;
}
