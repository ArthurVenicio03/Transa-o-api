package com.Arthur.transacao_api.infrastruture.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntity extends RuntimeException {
    public UnprocessableEntity(String message) {
        super(message);
    }
}
