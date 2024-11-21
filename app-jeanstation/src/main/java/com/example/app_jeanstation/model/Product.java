package com.example.app_jeanstation.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="Product_Details")
public class Product {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "Product_Name")
    private String productName;

    @Column(name = "Product_Price")
    private Double productPrice;

    @Column(name = "Product_Stock")
    private Integer productStock;

    @Column(name = "Product_Code", unique = true)  // productCode as unique identifier
    private String productCode;
}
