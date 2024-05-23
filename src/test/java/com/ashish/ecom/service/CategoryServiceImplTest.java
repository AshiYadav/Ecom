package com.ashish.ecom.service;

import com.ashish.ecom.entity.Category;
import com.ashish.ecom.entity.Product;
import com.ashish.ecom.exception.CategoryNotFoundException;
import com.ashish.ecom.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryServiceImpl;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTotalPriceOfProductsFetchedFromCategory(){
        //Arrange
        UUID sampleId = UUID.randomUUID();
        Optional<Category> cat = getCategoryMockData();
        Mockito.when(categoryRepository.findById(sampleId)).thenReturn(cat);

        //Act
        double actualOutcome = categoryServiceImpl.getTotalPrice(sampleId);
        double excpected = 300.00;
        //Assert
        Assertions.assertEquals(actualOutcome,excpected);
        Mockito.verify(categoryRepository).findById(sampleId);


    }

    @Test
    public void getTotalAmountIfProductAreNotPresent(){
        //Arrange
        UUID sampleID = UUID.randomUUID();
        Optional<Category> cat = getCategoryWithZeroProduct();
        Mockito.when(categoryRepository.findById(sampleID)).thenReturn(cat);

        //Act
        double totalPrice = categoryServiceImpl.getTotalPrice(sampleID);
        double expected = 0.00;

        //Assert
        Assertions.assertEquals(totalPrice,expected);
        Mockito.verify(categoryRepository).findById(sampleID);
    }

    @Test
    public void categoryNotExists(){

        //Arrange and Act
        UUID sampleId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(sampleId)).thenReturn(Optional.empty());

        Assertions.assertThrows(CategoryNotFoundException.class, ()->{
            categoryServiceImpl.getTotalPrice(sampleId);
        });
    }


    public Optional<Category> getCategoryWithZeroProduct(){
        Category cat = new Category();
        cat.setId(UUID.randomUUID());
        cat.setName("Category 1");
        List<Product> proList = new ArrayList<>();
        cat.setProducts(proList);
        return Optional.of(cat);
    }

    public Optional<Category> getCategoryMockData(){
        Category cat = new Category();
        cat.setId(UUID.randomUUID());
        cat.setName("Category 1");

        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setImageUrl("http");
        product1.setTitle("product1");
        product1.setRating(4.4);
        product1.setPrice(100.00);
        product1.setDescription("New product 1");
        product1.setCategory(cat);

        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setImageUrl("http");
        product2.setTitle("product1");
        product2.setRating(4.4);
        product2.setPrice(200.00);
        product2.setDescription("New product 1");
        product2.setCategory(cat);

        List<Product> li = new ArrayList<>();
        li.add(product1);
        li.add(product2);
        cat.setProducts(li);
        return Optional.of(cat);
    }
}
