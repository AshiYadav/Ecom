package com.ashish.ecom.exception;

public class NoProductFoundException extends RuntimeException{

    public NoProductFoundException(String message) {
        super(message);
    }
}
