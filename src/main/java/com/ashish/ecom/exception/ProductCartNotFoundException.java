package com.ashish.ecom.exception;

public class ProductCartNotFoundException extends RuntimeException{
    public ProductCartNotFoundException(String message) {
        super(message);
    }
}
