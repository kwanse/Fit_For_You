package com.kwanse.ably.common.model;

public class EmailFormatException extends RuntimeException {

    public EmailFormatException() {
        super();
    }

    public EmailFormatException(String message) {
        super(message);
    }

    public EmailFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
