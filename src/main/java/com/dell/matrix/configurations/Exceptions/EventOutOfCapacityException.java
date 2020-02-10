package com.dell.matrix.configurations.Exceptions;

public class EventOutOfCapacityException extends RuntimeException{
    public EventOutOfCapacityException(String message) {
        super(message);
    }
}
