package com.egabi.usermanagement.service;

import org.springframework.stereotype.Service;

import com.egabi.usermanagement.exceptions.ProductNotFoundException;
import com.egabi.usermanagement.model.Product;
import com.egabi.usermanagement.model.UserProduct;
import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServices {
    private final List<Product> products = new ArrayList<>();
    private final List<UserProduct> userProducts = new ArrayList<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @PostConstruct
    public void init() {
        // Initialize with sample products
        products.add(new Product(1, "Laptop", "High-performance laptop", 999.99, "Electronics", 1,
                "AVAILABLE", "laptop.jpg", 10, getCurrentDateTime(), getCurrentDateTime()));
        products.add(new Product(2, "Smartphone", "Latest smartphone model", 699.99, "Electronics", 1,
                "AVAILABLE", "phone.jpg", 15, getCurrentDateTime(), getCurrentDateTime()));
        products.add(new Product(3, "Desk Chair", "Ergonomic office chair", 199.99, "Furniture", 2,
                "AVAILABLE", "chair.jpg", 5, getCurrentDateTime(), getCurrentDateTime()));

        // Initialize some user-product relationships
        userProducts.add(new UserProduct(1, 1, getCurrentDateTime(), "OWNED"));
        userProducts.add(new UserProduct(2, 3, getCurrentDateTime(), "OWNED"));
    }

    private String getCurrentDateTime() {
        return LocalDateTime.now().format(formatter);
    }

    // Product Management Methods
    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Integer id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }


    public List<Product> getProductsByUser(Integer userId) {
        return products.stream()
                .filter(product -> product.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
