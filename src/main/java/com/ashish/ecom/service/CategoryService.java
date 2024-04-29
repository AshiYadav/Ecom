package com.ashish.ecom.service;


import com.ashish.ecom.dto.CategoryReponseDTO;
import com.ashish.ecom.dto.CategoryRequestDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    public List<CategoryReponseDTO> getAllCategory();
    public CategoryReponseDTO getCategoryBasedOnID(UUID id);

    public CategoryReponseDTO createCategory(CategoryRequestDTO dto);
    public CategoryReponseDTO updateCategory(CategoryRequestDTO dto, UUID id);
    public boolean deleteCategory(UUID id);
}
