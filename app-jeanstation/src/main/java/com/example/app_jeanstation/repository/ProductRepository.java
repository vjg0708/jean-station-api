package com.example.app_jeanstation.repository;

import com.example.app_jeanstation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    Optional<Product> findByProductCode(String productCode);  // Fetch product by productCode
}
