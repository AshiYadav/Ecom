package com.ashish.ecom.component;

import com.ashish.ecom.dto.CategoryReponseDTO;
import com.ashish.ecom.dto.CategoryRequestDTO;
import com.ashish.ecom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryReponseDTO>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryReponseDTO> getProductBaedOnID(@PathVariable("id") UUID id){
        return ResponseEntity.ok(null);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryReponseDTO> createCategory(@RequestBody CategoryRequestDTO dto){
        return ResponseEntity.ok(categoryService.createCategory(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryReponseDTO> updateCategory(@PathVariable("id") UUID id, @RequestBody CategoryRequestDTO dto){
        return  ResponseEntity.ok(categoryService.updateCategory(dto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") UUID id){
        return  ResponseEntity.ok(categoryService.deleteCategory(id));
    }
}
