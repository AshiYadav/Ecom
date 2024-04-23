package com.ashish.ecom.exception;

import com.ashish.ecom.component.CartController;
import com.ashish.ecom.dto.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerExceptionHandler {

    @ExceptionHandler({ProductCartNotFoundException.class})
    public ResponseEntity handleProductCartNotFound(ProductCartNotFoundException per){
        Exception exp = new Exception(per.getMessage(),400);
        return new ResponseEntity<>(exp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidUserIdSentException.class})
    public ResponseEntity invalidUserIdException(InvalidUserIdSentException ex){
        Exception exp = new Exception(ex.getMessage(),400);
        return new ResponseEntity(exp,HttpStatus.BAD_REQUEST);
    }
}
