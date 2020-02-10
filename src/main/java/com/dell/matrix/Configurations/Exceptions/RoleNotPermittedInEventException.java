package com.dell.matrix.Configurations.Exceptions;

public class RoleNotPermittedInEventException extends RuntimeException {
    public RoleNotPermittedInEventException(String message) {
        super(message);
    }
}
