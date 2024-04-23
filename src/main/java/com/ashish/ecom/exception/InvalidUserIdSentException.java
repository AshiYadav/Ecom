package com.ashish.ecom.exception;

public class InvalidUserIdSentException extends RuntimeException{
    public InvalidUserIdSentException() {
    }

    public InvalidUserIdSentException(String message) {
        super(message);
    }

    public InvalidUserIdSentException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserIdSentException(Throwable cause) {
        super(cause);
    }

    public InvalidUserIdSentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
