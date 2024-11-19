package com.example.app_jeanstation.DTO;

import com.example.app_jeanstation.model.Product;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class OrderDTO {

    private Long orderId;
    private Long productId;
    private Integer quantity;
    private String status;
}
