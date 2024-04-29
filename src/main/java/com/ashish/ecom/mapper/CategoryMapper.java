package com.ashish.ecom.mapper;

import com.ashish.ecom.dto.CategoryReponseDTO;
import com.ashish.ecom.dto.CategoryRequestDTO;
import com.ashish.ecom.dto.ProductRequestDTO;
import com.ashish.ecom.dto.ProductResponseDTO;
import com.ashish.ecom.entity.Category;
import com.ashish.ecom.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static CategoryReponseDTO convertEntityToDTO(Category cat){
        CategoryReponseDTO categoryResponseDTO = new CategoryReponseDTO();
        categoryResponseDTO.setName(cat.getName());
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        if(!(cat.getProducts() == null || cat.getProducts().isEmpty())) {
            for (Product product : cat.getProducts()) {
                productResponseDTOs.add(ProductEntityToProductResponseDTO.convertEntityToDTO(product));
            }
        }
        categoryResponseDTO.setProducts(productResponseDTOs);
        return categoryResponseDTO;
    }

    public  static Category convertDTOToEntity(CategoryRequestDTO dto){
        Category pro = new Category();
        pro.setName(dto.getName());
        pro.setId(dto.getId());
        return pro;
    }
}
