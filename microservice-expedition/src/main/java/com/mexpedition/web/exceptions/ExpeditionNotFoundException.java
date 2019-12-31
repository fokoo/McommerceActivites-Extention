package com.mexpedition.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExpeditionExistantException extends RuntimeException {

    public ExpeditionExistantException(String message) {
        super(message);
    }
}
