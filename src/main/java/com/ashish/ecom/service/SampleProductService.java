package com.ashish.ecom.service;

import com.ashish.ecom.dto.FakestoreRessponseDTO;
import com.ashish.ecom.entity.Product;
import com.ashish.ecom.exception.ProductNotFoundException;
import com.ashish.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SampleProductService {

        @Autowired
        private ProductRepository productRepository;



        public List<Product> getAllProduct() {
            return productRepository.findAll();
        }


        public Product createProduct(Product product) {
            Product saveProduct = productRepository.save(product);
            return saveProduct;
        }


        public Product getProduct(UUID id) {
            return productRepository.findById(id).orElseThrow(
                    ()-> new ProductNotFoundException("No product found for this Id")
            );
        }


        public Product updateProduct(Product product, UUID id) {
            Product saved = productRepository.findById(id).orElseThrow(
                    ()-> new ProductNotFoundException("No product found for this Id")
            );

            saved.setCategory(product.getCategory());
            saved.setDescription(product.getDescription());
            saved.setTitle(product.getTitle());
            saved.setRating(product.getRating());
            saved.setPrice(product.getPrice());
            saved.setImageUrl(product.getImageUrl());

            saved = productRepository.save(saved);
            return saved;
        }


        public boolean deleteProduct(UUID id) {
            productRepository.deleteById(id);
            return true;
        }

        public List<Product> getProductBetween(double a, double b){
            return productRepository.findByPriceBetween(a,b);
        }

        public Product getProductBasedOnTitle(String title){
            return productRepository.findByTitle(title);
        }

        public List<Product> getProductBasedOnTitleLike(String title){
            return productRepository.findByTitleEndingWith(title);
        }
}
