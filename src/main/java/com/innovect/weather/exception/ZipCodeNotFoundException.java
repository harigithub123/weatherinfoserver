package com.innovect.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ZipCodeNotFoundException extends RuntimeException {
    public ZipCodeNotFoundException() {
        super();
    }
    public ZipCodeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ZipCodeNotFoundException(String message) {
        super(message);
    }
    public ZipCodeNotFoundException(Throwable cause) {
        super(cause);
    }
}