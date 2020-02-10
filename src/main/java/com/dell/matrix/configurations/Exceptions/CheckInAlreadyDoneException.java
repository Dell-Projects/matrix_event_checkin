package com.dell.matrix.configurations.Exceptions;

public class CheckInAlreadyDoneException extends RuntimeException {
    public CheckInAlreadyDoneException(String message) {
        super(message);
    }
}
