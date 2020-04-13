package com.musinsa.test.application.controller;

import com.musinsa.test.application.exception.NotFoundUrlException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundUrlException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public void onNotFoundUrlException(NotFoundUrlException e) {
        log.info(e.getMessage());
    }
}
