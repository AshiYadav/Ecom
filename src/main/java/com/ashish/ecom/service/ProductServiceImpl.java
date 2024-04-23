package com.ashish.ecom.service;

import com.ashish.ecom.dto.FakestoreRessponseDTO;
import com.ashish.ecom.entity.Product;
import com.ashish.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<FakestoreRessponseDTO> getAllProduct() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public FakestoreRessponseDTO getProduct(int id) {
        return null;
    }

    @Override
    public Product updateProduct(Product product, int id) {
        return null;
    }

    @Override
    public void deleteProduct(int id) {

    }
}
