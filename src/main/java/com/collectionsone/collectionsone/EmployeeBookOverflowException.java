package com.collectionsone.collectionsone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
public class EmployeeBookOverflowException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Employee book is full";

    public EmployeeBookOverflowException() {
        this(DEFAULT_MESSAGE);
    }

    public EmployeeBookOverflowException(String message) {
        super(message);
    }
}
