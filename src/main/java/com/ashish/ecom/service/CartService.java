package com.ashish.ecom.service;

import com.ashish.ecom.dto.CartResponseDTO;
import com.ashish.ecom.dto.Products;

import java.util.List;

public interface CartService {

    public List<CartResponseDTO> getCartItemsBasedOnUserID(int userId);
}
