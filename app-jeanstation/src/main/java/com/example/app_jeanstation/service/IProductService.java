package com.example.app_jeanstation.service;

import com.example.app_jeanstation.DTO.ProductDTO;

import java.util.List;

public interface IProductService {

    public ProductDTO getProductById(Long id);

    public List<ProductDTO> getAllProducts();

    public String addProduct(ProductDTO productDTO);

    public String addAllProducts(List<ProductDTO> productsDTO);

    public String updateProductById(Long id, ProductDTO productDTO);

    public ProductDTO updateProductName(Long id, String productName);

    public ProductDTO updateProductPrice(Long id, Double productPrice);

    public ProductDTO updateProductStock(Long id, Integer productStock);

    public String deleteProductById(Long id);

    public String deleteAllProducts();

}
