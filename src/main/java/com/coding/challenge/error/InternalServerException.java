package com.coding.challenge.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {

    private static final long serialVersionUID = -3323653376824784568L;

    public InternalServerException(final String message) {
        super(message);
    }
}
