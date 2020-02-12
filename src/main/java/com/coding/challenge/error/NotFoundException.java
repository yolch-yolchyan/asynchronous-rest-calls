package com.coding.challenge.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3651682396070351519L;

    public NotFoundException(final String message) {
        super(message);
    }
}
