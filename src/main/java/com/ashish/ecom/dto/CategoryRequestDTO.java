package com.ashish.ecom.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoryRequestDTO {

    String name;
    UUID id;
}
