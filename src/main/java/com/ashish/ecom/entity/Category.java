package com.ashish.ecom.entity;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Category extends BaseModel{

    String name;
    UUID id;
}
