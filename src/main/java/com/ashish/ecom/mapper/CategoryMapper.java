package com.ashish.ecom.mapper;

import com.ashish.ecom.dto.CategoryReponseDTO;
import com.ashish.ecom.dto.CategoryRequestDTO;
import com.ashish.ecom.dto.ProductRequestDTO;
import com.ashish.ecom.dto.ProductResponseDTO;
import com.ashish.ecom.entity.Category;
import com.ashish.ecom.entity.Product;

public class CategoryMapper {

    public static CategoryReponseDTO convertEntityToDTO(Category cat){
        CategoryReponseDTO dto = new CategoryReponseDTO();
        dto.setName(cat.getName());
        dto.setId(cat.getId());
        return dto;
    }

    public  static Category convertDTOToEntity(CategoryRequestDTO dto){
        Category pro = new Category();
        pro.setName(dto.getName());
        pro.setId(dto.getId());
        return pro;
    }
}
