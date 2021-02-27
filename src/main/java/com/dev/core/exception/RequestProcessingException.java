package com.dev.core.exception;

public class RequestProcessingException extends RuntimeException {
    public RequestProcessingException(String message) {
        super(message);
    }
    
    public RequestProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
