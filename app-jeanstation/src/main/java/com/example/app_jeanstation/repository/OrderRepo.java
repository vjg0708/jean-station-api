package com.example.app_jeanstation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app_jeanstation.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}