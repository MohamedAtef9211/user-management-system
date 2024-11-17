package com.egabi.usermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProduct {
    private Integer userId;
    private Integer productId;
    private String purchaseDate;
    private String status;
}
