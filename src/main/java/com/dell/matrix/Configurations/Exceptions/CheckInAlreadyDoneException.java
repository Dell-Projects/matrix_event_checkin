package com.dell.matrix.Configurations.Exceptions;

public class CheckInAlreadyDoneException extends RuntimeException {
    public CheckInAlreadyDoneException(String message) {
        super(message);
    }
}
