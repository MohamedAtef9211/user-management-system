package com.egabi.usermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private Integer userId;
    private String status;
    private String imageUrl;
    private Integer stockQuantity;
    private String createdDate;
    private String lastModifiedDate;
}
