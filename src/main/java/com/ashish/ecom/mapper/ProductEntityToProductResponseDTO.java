package com.ashish.ecom.mapper;

import com.ashish.ecom.dto.ProductResponseDTO;
import com.ashish.ecom.entity.Product;

public class ProductEntityToProductResponseDTO {

    public static ProductResponseDTO convertEntityToDTO(Product product){
        ProductResponseDTO dto = new ProductResponseDTO();
//        dto.setProductId(product.getId());
        dto.setDesc(product.getDescription());
        dto.setCategory(product.getCategory());
        dto.setPrice(product.getPrice());
        dto.setTitle(product.getTitle());
        dto.setRating(product.getRating());
        return dto;
    }
}
