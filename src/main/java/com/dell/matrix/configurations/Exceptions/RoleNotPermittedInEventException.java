package com.dell.matrix.configurations.Exceptions;

public class RoleNotPermittedInEventException extends RuntimeException {
    public RoleNotPermittedInEventException(String message) {
        super(message);
    }
}
