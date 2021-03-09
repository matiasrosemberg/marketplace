package com.example.selfemployedmarketplace.exception;

public class NotValidProjectKeyException extends RuntimeException {
    public NotValidProjectKeyException() {
    }

    public NotValidProjectKeyException(String s) {
        super(s);
    }

    public NotValidProjectKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidProjectKeyException(Throwable cause) {
        super(cause);
    }

    public NotValidProjectKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
