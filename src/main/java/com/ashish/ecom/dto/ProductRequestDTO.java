package com.ashish.ecom.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductRequestDTO {

    private UUID id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private double rating;
}
