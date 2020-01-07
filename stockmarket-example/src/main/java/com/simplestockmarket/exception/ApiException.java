package com.simplestockmarket.exception;

import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiException extends RuntimeException{
    private static final long serialVersionUID = 111988443560228411L;

    protected Code errorCode;

    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Code errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(Code errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public Code getErrorCode() {
        return errorCode;
    }
}
