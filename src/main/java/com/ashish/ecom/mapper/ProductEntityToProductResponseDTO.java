package com.ashish.ecom.mapper;

import com.ashish.ecom.dto.ProductRequestDTO;
import com.ashish.ecom.dto.ProductResponseDTO;
import com.ashish.ecom.entity.Product;

public class ProductEntityToProductResponseDTO {

    public static ProductResponseDTO convertEntityToDTO(Product product){
        ProductResponseDTO dto = new ProductResponseDTO();
//        dto.setProductId(product.getId());
        dto.setDesc(product.getDescription());
        dto.setCategory(product.getCategory().getName());
        dto.setPrice(product.getPrice());
        dto.setTitle(product.getTitle());
        dto.setRating(product.getRating());
        dto.setProductId(product.getId());
        return dto;
    }

    public  static Product convertDTOToEntity(ProductRequestDTO dto){
        Product pro = new Product();
        //pro.setCategory(dto.getCategory());
        pro.setRating(dto.getRating());
        pro.setPrice(dto.getPrice());
        pro.setTitle(dto.getTitle());
        pro.setImageUrl(dto.getImage());
        pro.setId(dto.getId());
        return pro;
    }
}
