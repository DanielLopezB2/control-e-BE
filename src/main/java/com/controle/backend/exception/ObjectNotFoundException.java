package com.controle.backend.exception;

import lombok.Getter;

public class ObjectNotFoundException extends RuntimeException{

    @Getter
    private final String objectNotFoundName;
    private final Throwable cause;

    public ObjectNotFoundException(String objectNotFoundName) {
        this.objectNotFoundName = objectNotFoundName;
        this.cause = null;
    }

    public ObjectNotFoundException(String objectNotFoundName, Throwable cause) {
        this.objectNotFoundName = objectNotFoundName;
        this.cause = cause;
    }

    @Override
    public String getMessage() {

        String message = super.getMessage();

        if (message == null) {
            message = "";
        }

        return message
                .concat(" Object not found: ").concat(this.objectNotFoundName);
    }

}