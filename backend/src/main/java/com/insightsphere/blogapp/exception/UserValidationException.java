package com.insightsphere.blogapp.exception;

import java.util.List;

public class UserValidationException extends RuntimeException {
    private List<String> errors;

    public UserValidationException(List<String> errors) {
        super("User validation failed");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
