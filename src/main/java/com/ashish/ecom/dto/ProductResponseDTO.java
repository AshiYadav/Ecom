package com.ashish.ecom.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO {

    private UUID productId;
    private String title;
    private String desc;
    private double price;
    private String category;
    private String imageUrl;
    private double rating;
}
