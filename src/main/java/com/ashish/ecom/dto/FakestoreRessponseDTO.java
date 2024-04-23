package com.ashish.ecom.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreRessponseDTO {

    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private FakestoreProductRatingResponseDTO rating;
}
