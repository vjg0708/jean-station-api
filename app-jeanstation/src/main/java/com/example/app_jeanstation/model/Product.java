package com.example.app_jeanstation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductDetails")
public class Product {

    @Id
    @Column(name = "Product_Id")
    private Integer productId;

    @Column(name = "Product_Name")
    private String productName;

    @Column(name = "Product_Price")
    private Double productPrice;

    public Product() {
    }

    public Product(Integer productId, String productName, Double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
