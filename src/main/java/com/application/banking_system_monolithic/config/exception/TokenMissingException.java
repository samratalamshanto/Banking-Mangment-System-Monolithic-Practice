package com.application.banking_system_monolithic.config.exception;

public class TokenMissingException extends RuntimeException {
    public TokenMissingException() {
    }

    public TokenMissingException(String message) {
        super(message);
    }
}
