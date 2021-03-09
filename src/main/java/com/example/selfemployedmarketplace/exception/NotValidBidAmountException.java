package com.example.selfemployedmarketplace.exception;

public class NotValidBidAmountException extends RuntimeException {
    public NotValidBidAmountException() {
    }

    public NotValidBidAmountException(String message) {
        super(message);
    }

    public NotValidBidAmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidBidAmountException(Throwable cause) {
        super(cause);
    }

    public NotValidBidAmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
