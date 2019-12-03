package com.viandasya.webservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class Maximum20ValidMenusException extends RuntimeException {
    public Maximum20ValidMenusException() {
        super("New menus can't be created, maximum of 20 valid menus reached");
    }
}
