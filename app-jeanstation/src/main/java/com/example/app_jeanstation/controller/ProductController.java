package com.example.app_jeanstation.controller;

import com.example.app_jeanstation.DTO.ProductDTO;
import com.example.app_jeanstation.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jean-station")
public class ProductController {

    @Autowired
    ProductServiceImp productService;

    @Secured("ROLE_USER")
    @GetMapping("/getProduct/{id}")
    public ProductDTO display(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @Secured("ROLE_USER")
    @PostMapping("/addProducts")
    public String createAll(@RequestBody List<ProductDTO> productsDTO) {
        return productService.addAllProducts(productsDTO);
    }

    @Secured( "ROLE_USER")
    @GetMapping("/getAllProducts")
    public List<ProductDTO> displayAll() {
        return productService.getAllProducts();
    }

    @Secured("ROLE_USER")
    @PostMapping("/addProduct")
    public String create(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @Secured("ROLE_USER")
    @PutMapping("/updateProduct/{id}")
    public String update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProductById(id, productDTO);
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/deleteProduct/{id}")
    public String remove(@PathVariable Long id) {
        return productService.deleteProductById(id);
    }
}
