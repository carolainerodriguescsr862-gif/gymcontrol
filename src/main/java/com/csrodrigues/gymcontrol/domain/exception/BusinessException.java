package com.csrodrigues.gymcontrol.domain.exception;

public class BusinessException extends  RuntimeException{

    public BusinessException(String message) {
        super(message);
    }
}
