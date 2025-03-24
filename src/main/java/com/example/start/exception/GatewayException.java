package com.example.start.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class GatewayException extends RuntimeException {
    public GatewayException(String message) {
        super(message);
    }
}
