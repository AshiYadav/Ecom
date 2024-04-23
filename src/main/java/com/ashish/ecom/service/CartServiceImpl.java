package com.ashish.ecom.service;

import com.ashish.ecom.client.FakestoreClient;
import com.ashish.ecom.dto.CartResponseDTO;
import com.ashish.ecom.dto.Products;
import com.ashish.ecom.exception.ProductCartNotFoundException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private FakestoreClient fakestoreClient;
    @Override
    public List<CartResponseDTO> getCartItemsBasedOnUserID(int userId) {
        List<CartResponseDTO> dto = fakestoreClient.getCartBasedOnUserId(userId);
        if(dto == null){
            throw new ProductCartNotFoundException("No product cart found exception for user id "+userId);
        }
        return dto;
    }
}
