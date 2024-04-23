package com.ashish.ecom.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exception {

    private String message;
    private int code;

    public Exception(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
