package com.example.selfemployedmarketplace.exception;

public class NotAvailableBidException extends RuntimeException {
    public NotAvailableBidException() {
    }

    public NotAvailableBidException(String message) {
        super(message);
    }

    public NotAvailableBidException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAvailableBidException(Throwable cause) {
        super(cause);
    }

    public NotAvailableBidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
