package com.ashish.ecom.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private int productId;
    private String title;
    private String desc;
    private double price;
    private String category;
    private String imageUrl;
    private double rating;
}
