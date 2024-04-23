package com.ashish.ecom.service;

import com.ashish.ecom.dto.FakestoreRessponseDTO;
import com.ashish.ecom.entity.Product;

import java.util.List;

public interface ProductService {

    public List<FakestoreRessponseDTO> getAllProduct();
    public Product createProduct(Product product);

    public FakestoreRessponseDTO getProduct(int id);

    public Product updateProduct(Product product, int id);

    public void deleteProduct(int id);

}
