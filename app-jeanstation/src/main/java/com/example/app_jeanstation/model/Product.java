package com.example.app_jeanstation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Product_Details")
public class Product {

    @Id
    @Column(name = "Product_Id")
    private  Long productId;

    @Column(name = "Product_Name")
    private String productName;

    @Column(name = "Product_Price")
    private Double productPrice;

    @Column(name = "Product_Stock")
    private  Integer productStock;



}
