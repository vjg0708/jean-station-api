package com.example.app_jeanstation.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ProductDTO {

	private Long productId;
	private String productName;
	private Double productPrice;
	private Integer productStock;
	private String productCode;
}
