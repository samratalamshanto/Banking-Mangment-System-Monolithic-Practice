package com.application.banking_system_monolithic.config.exception;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException() {
    }

    public InvalidTokenException(String message) {
        super(message);
    }
}
