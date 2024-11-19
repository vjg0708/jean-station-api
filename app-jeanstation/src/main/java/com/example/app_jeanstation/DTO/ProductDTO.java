package com.example.app_jeanstation.DTO;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
public class ProductDTO {

    private Long productId;
    private String productName;
    private Double productPrice;
    private Integer productStock;
}
