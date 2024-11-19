package com.example.app_jeanstation.controller;

import com.example.app_jeanstation.model.Product;

import com.example.app_jeanstation.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jean-station")
public class ProductController {

    @Autowired
    ProductServiceImp productService;

    @GetMapping(value = "/displayProduct/{id}")
    public Product viewProduct(@PathVariable Integer id){

        return productService.getProductById(id);
    }

    @GetMapping("/displayAllProducts")
    public List<Product> viewAllProducts(){

        return productService.getAllProducts();
    }

    @PostMapping("/createProduct")
    public String addProduct(@RequestBody Product product){

        return productService.addProduct(product);
    }

    @PostMapping("/createlistOfProducts")
    public String addAllProducts(@RequestBody List<Product> products){

        return productService.addAllProducts(products);
    }

    @PutMapping("/updateProductById/{id}")
    public String updateProduct(@PathVariable Integer id,
                                @RequestBody Product product){

        return productService.updateProductById(id, product);
    }

    @PatchMapping("/updateProductName/{id}")
    public Product changeProductName(@PathVariable Integer id,
                                    @RequestBody String productName){

        return productService.updateProductNameById(id, productName);
    }

    @PatchMapping("/updateProductPrice/{id}")
    public Product changeProductPrice(@PathVariable Integer id,
                                      @RequestBody Double productPrice){

        return productService.updateProductPriceById(id, productPrice);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String removeProductById(@PathVariable Integer id){

        return productService.deleteProductById(id);
    }

    @DeleteMapping("/deleteAllProducts")
    public String removeAllProducts(){

        return productService.deleteAllProducts();
    }

    
}
