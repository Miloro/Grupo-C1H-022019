package com.viandasya.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidOffersException extends RuntimeException {
    public InvalidOffersException() {
        super("InvalidOffers");
    }
}
