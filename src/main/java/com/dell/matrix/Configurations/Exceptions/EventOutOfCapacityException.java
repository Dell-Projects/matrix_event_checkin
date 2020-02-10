package com.dell.matrix.Configurations.Exceptions;

public class EventOutOfCapacityException extends RuntimeException{
    public EventOutOfCapacityException(String message) {
        super(message);
    }
}
