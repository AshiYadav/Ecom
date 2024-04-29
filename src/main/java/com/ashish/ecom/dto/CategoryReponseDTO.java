package com.ashish.ecom.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryReponseDTO {

    String name;
     List<ProductResponseDTO> products;
    UUID id;
}
