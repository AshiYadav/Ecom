package com.ashish.ecom.service;

import com.ashish.ecom.dto.CategoryReponseDTO;
import com.ashish.ecom.dto.CategoryRequestDTO;
import com.ashish.ecom.repository.CategoryRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryReponseDTO> getAllCategory() {
        return null;
    }

    @Override
    public CategoryReponseDTO getCategoryBasedOnID() {
        return null;
    }

    @Override
    public CategoryReponseDTO createCategory(CategoryRequestDTO dto) {
        return null;
    }

    @Override
    public CategoryReponseDTO updateCategory(CategoryRequestDTO dto, UUID id) {
        return null;
    }

    @Override
    public boolean deleteCategory(UUID id) {
        return false;
    }
}
