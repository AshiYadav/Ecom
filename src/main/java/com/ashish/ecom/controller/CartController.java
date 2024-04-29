package com.ashish.ecom.controller;

import com.ashish.ecom.dto.CartResponseDTO;
import com.ashish.ecom.exception.InvalidUserIdSentException;
import com.ashish.ecom.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/carts/{userID}")
    public ResponseEntity<List<CartResponseDTO>> getcartItems(@PathVariable("userID") int userId){
        if(userId < 1){
            throw  new InvalidUserIdSentException("Invalid user id sent in request");
        }
        List<CartResponseDTO> dto = cartService.getCartItemsBasedOnUserID(userId);
        return ResponseEntity.ok(dto);
    }
}
