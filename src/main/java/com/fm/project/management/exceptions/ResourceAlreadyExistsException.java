package com.fm.project.management.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
