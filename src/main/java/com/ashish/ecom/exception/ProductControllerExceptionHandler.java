package com.ashish.ecom.exception;

import com.ashish.ecom.component.ProductController;
import com.ashish.ecom.dto.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerExceptionHandler {


    //We can combine two exception in one exception handler as done below
    @ExceptionHandler({ProductNotFoundException.class,NoProductFoundException.class})
    public ResponseEntity productNotFoundException(ProductNotFoundException pr){
        Exception exp = new Exception(pr.getMessage(),404);
        return new ResponseEntity<>(exp, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler({NoProductFoundException.class})
//    public ResponseEntity noProductFoundInList(NoProductFoundException ex){
//
//        Exception exp = new Exception(ex.getMessage(),404);
//        return new ResponseEntity<>(exp,HttpStatus.NOT_FOUND);
//
//    }
}
