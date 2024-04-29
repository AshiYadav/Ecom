package com.ashish.ecom.service;

import com.ashish.ecom.dto.CategoryReponseDTO;
import com.ashish.ecom.dto.CategoryRequestDTO;
import com.ashish.ecom.entity.Category;
import com.ashish.ecom.exception.CategoryNotFoundException;
import com.ashish.ecom.mapper.CategoryMapper;
import com.ashish.ecom.repository.CategoryRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryReponseDTO> getAllCategory() {
        List<Category> catList = categoryRepository.findAll();
        List<CategoryReponseDTO> catDto = catList.stream().map(cat ->{
            return CategoryMapper.convertEntityToDTO(cat);
        }).collect(Collectors.toList());
        return catDto;
    }

    @Override
    public CategoryReponseDTO getCategoryBasedOnID(UUID id) {

        Category cat = categoryRepository.findById(id).orElseThrow(()->{
            return new CategoryNotFoundException("Category not found");
        });

        return CategoryMapper.convertEntityToDTO(cat);
    }

    @Override
    public CategoryReponseDTO createCategory(CategoryRequestDTO dto) {

        Category cat = categoryRepository.save(CategoryMapper.convertDTOToEntity(dto));
        return CategoryMapper.convertEntityToDTO(cat);
    }

    @Override
    public CategoryReponseDTO updateCategory(CategoryRequestDTO dto, UUID id) {
        Category fetchedCat = categoryRepository.findById(id).orElseThrow(()->{
            return new CategoryNotFoundException("Category not found");
        });
        fetchedCat.setName(dto.getName());
        Category updatedCat = categoryRepository.save(fetchedCat);
        return CategoryMapper.convertEntityToDTO(updatedCat);
    }

    @Override
    public boolean deleteCategory(UUID id) {

        categoryRepository.deleteById(id);
        return true;
    }
}
