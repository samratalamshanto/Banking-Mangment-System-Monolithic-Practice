package com.application.banking_system_monolithic.config.exception;

public class ClientSideException extends RuntimeException {
    public ClientSideException(String message) {
        super(message);
    }

    public ClientSideException(String message, Throwable cause) {
    }

}
