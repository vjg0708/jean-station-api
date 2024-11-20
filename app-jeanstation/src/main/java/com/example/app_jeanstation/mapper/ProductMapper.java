package com.example.app_jeanstation.mapper;

import com.example.app_jeanstation.DTO.ProductDTO;
import com.example.app_jeanstation.model.Product;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Component
public class ProductMapper {

    public static ProductDTO convertToDTO(Product product){

        return ProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productStock(product.getProductStock())
                .productCode(product.getProductCode())
                .build();
    }

    public static Product convertToEntity(ProductDTO productDTO){

        return Product.builder()
                .id(productDTO.getId())
                .productName(productDTO.getProductName())
                .productPrice(productDTO.getProductPrice())
                .productStock(productDTO.getProductStock())
                .productCode(productDTO.getProductCode())
                .build();
    }

    public static List<ProductDTO> convertToDTOs(List<Product> products){

        return products.stream()
                .map(ProductMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    public static List<Product> convertToEntities(List<ProductDTO> productDTOSs){

        return productDTOSs.stream()
                .map(ProductMapper::convertToEntity)
                .collect(Collectors.toList());
    }
}
