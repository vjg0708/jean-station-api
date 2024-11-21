//package com.example.app_jeanstation.controller;
//
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/jean-station")
//public class RoleController {
//
//    // Admins can view all orders
//    @Secured("ROLE_ADMIN")
//    @GetMapping("role/allorders")
//    public String getAllOrders() {
//        // Logic to return all orders
//        return "All orders displayed for Admin.";
//    }
//
//    // Users can place an order
//    @Secured("ROLE_USER")
//    @PostMapping("role/placeorder")
//    public String placeOrder() {
//        // Logic to place an order
//        return "Order placed successfully.";
//    }
//
//    // Admins can release an order by id
//    @Secured("ROLE_ADMIN")
//    @PutMapping("role/{id}/release")
//    public String releaseOrder(@PathVariable Long id) {
//        // Logic to release the order by ID
//        return "Order " + id + " released.";
//    }
//
//    // Users can delete their own order by id
//    @Secured("ROLE_USER")
//    @DeleteMapping("role/{id}/deleteorder")
//    public String deleteOrder(@PathVariable Long id) {
//        // Logic to delete the order by ID
//        return "Order " + id + " deleted.";
//    }
//}
