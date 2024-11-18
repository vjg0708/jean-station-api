package com.example.app_jeanstation.service;

import com.example.app_jeanstation.model.Product;

import java.util.List;

public interface IProductService {

    public Product getProductById(Integer id);

    public List<Product> getAllProducts();

    public String addProduct(Product product);

    public String addAllProducts(List<Product> products);

    public String updateProductById(Integer id, Product product);

    public Product updateProductNameById(Integer id, String productName);

    public Product updateProductPriceById(Integer id, Double productPrice);

    public String deleteProductById(Integer id);

    public String deleteAllProducts();

}
