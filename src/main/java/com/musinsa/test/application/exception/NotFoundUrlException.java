package com.musinsa.test.application.exception;

public class NotFoundUrlException extends RuntimeException {
    private final String code;

    public NotFoundUrlException(String code) {
        super("url not found. code = " + code);
        this.code = code;
    }
}
