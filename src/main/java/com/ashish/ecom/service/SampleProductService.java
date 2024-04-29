package com.ashish.ecom.service;

import com.ashish.ecom.dto.FakestoreRessponseDTO;
import com.ashish.ecom.dto.ProductRequestDTO;
import com.ashish.ecom.dto.ProductResponseDTO;
import com.ashish.ecom.entity.Product;
import com.ashish.ecom.exception.ProductNotFoundException;
import com.ashish.ecom.mapper.ProductEntityToProductResponseDTO;
import com.ashish.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SampleProductService {

        @Autowired
        private ProductRepository productRepository;



        public List<ProductResponseDTO> getAllProduct() {
            List<Product> list = productRepository.findAll();
            return list.stream().map(ProductEntityToProductResponseDTO ::convertEntityToDTO).collect(Collectors.toList());

        }


        public ProductResponseDTO createProduct(ProductRequestDTO product) {
            Product pp = ProductEntityToProductResponseDTO.convertDTOToEntity(product);
            Product saveProduct = productRepository.save(pp);
            return ProductEntityToProductResponseDTO.convertEntityToDTO(saveProduct);

        }


        public ProductResponseDTO getProduct(UUID id) {
            Product product =  productRepository.findById(id).orElseThrow(
                    ()-> new ProductNotFoundException("No product found for this Id")
            );
            return ProductEntityToProductResponseDTO.convertEntityToDTO(product);
        }


        public ProductResponseDTO updateProduct(ProductRequestDTO product, UUID id) {
            Product saved = productRepository.findById(id).orElseThrow(
                    ()-> new ProductNotFoundException("No product found for this Id")
            );

//            saved.setCategory(product.getCategory());
            saved.setDescription(product.getDescription());
            saved.setTitle(product.getTitle());
            saved.setRating(product.getRating());
            saved.setPrice(product.getPrice());
            saved.setImageUrl(product.getImage());

            saved = productRepository.save(saved);
            return ProductEntityToProductResponseDTO.convertEntityToDTO(saved);

        }


        public boolean deleteProduct(UUID id) {
            productRepository.deleteById(id);
            return true;
        }

        public List<ProductResponseDTO> getProductBetween(double a, double b){
            List<Product> li = productRepository.findByPriceBetween(a,b);

            return li.stream().map(ProductEntityToProductResponseDTO::convertEntityToDTO).collect(Collectors.toList());
        }

        public ProductResponseDTO getProductBasedOnTitle(String title){

            return ProductEntityToProductResponseDTO.convertEntityToDTO(productRepository.findByTitle(title));
        }

        public List<ProductResponseDTO> getProductBasedOnTitleLike(String title){
            List<Product> li = productRepository.findByTitleEndingWith(title);
            return li.stream().map(ProductEntityToProductResponseDTO::convertEntityToDTO).collect(Collectors.toList());
        }
}
