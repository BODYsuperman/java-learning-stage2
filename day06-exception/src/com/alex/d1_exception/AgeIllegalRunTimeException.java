package com.alex.d1_exception;

public class AgeIllegalRunTimeException extends RuntimeException{

    public AgeIllegalRunTimeException() {
    }

    public AgeIllegalRunTimeException(String message) {
        super(message);
    }
}
