package com.example.app_jeanstation.controller;

import com.example.app_jeanstation.DTO.ProductDTO;
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

    @GetMapping("/getProduct/{id}")
    public ProductDTO display(@PathVariable Long id){

        return productService.getProductById(id);
    }

    @GetMapping("/getAllProducts")
    public List<ProductDTO> displayAll(){

        return productService.getAllProducts();
    }

    @PostMapping("/addProduct")
    public String create(@RequestBody ProductDTO productDTO){

        return productService.addProduct(productDTO);
    }

    @PostMapping("/addAllProducts")
    public String createAll(@RequestBody List<ProductDTO> productDTOS){

        return productService.addAllProducts(productDTOS);
    }

    @PutMapping("/updateProduct/{id}")
    public String update(@PathVariable Long id,
                         @RequestBody ProductDTO productDTO){

        return productService.updateProductById(id, productDTO);
    }

    @PatchMapping("/updateProductName/{id}")
    public ProductDTO updateName(@PathVariable Long id, @RequestBody ProductDTO product){

        return productService.updateProductName(id, product.getProductName());
    }

    @PatchMapping("/updateProductPrice/{id}")
    public ProductDTO updatePrice(@PathVariable Long id, @RequestBody ProductDTO product){

        return productService.updateProductPrice(id, product.getProductPrice());
    }

    @PatchMapping("/updateProductStock/{id}")
    public ProductDTO updateStock(@PathVariable Long id, @RequestBody ProductDTO product){

        return productService.updateProductStock(id, product.getProductStock());
    }

    @PatchMapping("/updateProductCode/{id}")
    public ProductDTO updateProductCode(@PathVariable Long id, @RequestBody ProductDTO product){

        return productService.updateProductCode(id, product.getProductCode());
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String remove(@PathVariable Long id){

        return productService.deleteProductById(id);
    }

    @DeleteMapping("/deleteAllProducts")
    public String removeAll(){

        return productService.deleteAllProducts();
    }

    
}
