package com.ashish.ecom.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseModel{


    private String title;
    private String description;
    private double price;
    private String category;
    private String imageUrl;
    private double rating;

}
