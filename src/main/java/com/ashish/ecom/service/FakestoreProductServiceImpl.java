package com.ashish.ecom.service;

import com.ashish.ecom.client.FakestoreClient;
import com.ashish.ecom.dto.FakestoreRessponseDTO;
import com.ashish.ecom.entity.Product;
import com.ashish.ecom.exception.NoProductFoundException;
import com.ashish.ecom.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeStoreProductServiceImpl")
public class FakestoreProductServiceImpl implements ProductService{

    @Autowired
    private FakestoreClient fakestoreClient;


    @Override
    public List<FakestoreRessponseDTO> getAllProduct() {
        List<FakestoreRessponseDTO> list = fakestoreClient.getAllProduct();
        if(list == null){
            throw  new NoProductFoundException("No product present in list");
        }
        return list;

    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public FakestoreRessponseDTO getProduct(int id) throws ProductNotFoundException {
        FakestoreRessponseDTO dto = fakestoreClient.getProductBasedOnID(id);
        if(dto == null){
            throw new ProductNotFoundException("Product not found for this id"+id);
        }
        return dto;
    }

    @Override
    public Product updateProduct(Product product, int id) {
        return null;
    }

    @Override
    public void deleteProduct(int id) {

    }
}
