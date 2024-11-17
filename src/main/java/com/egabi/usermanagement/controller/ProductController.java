package com.egabi.usermanagement.controller;

import com.egabi.usermanagement.model.BaseResponse;
import com.egabi.usermanagement.model.Product;
import com.egabi.usermanagement.service.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {
    private final ProductServices productServices;

    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(new BaseResponse(true,productServices.getAllProducts()));
    }

    /**
     * Get product by ID
     * GET /api/products/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(new BaseResponse(true,productServices.getProductById(id)));
    }

    /**
     * Get products by user ID
     * GET /api/products/user/{userId}
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity getProductsByUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(new BaseResponse(true,productServices.getProductsByUser(userId)));

    }
}
