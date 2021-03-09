package com.example.selfemployedmarketplace.exception;

public class JsonParsingException extends RuntimeException {
    public JsonParsingException(String failed_from_string_to_jsonNode) {
    }

    public JsonParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonParsingException(Throwable cause) {
        super(cause);
    }

    public JsonParsingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public JsonParsingException() {
    }
}
