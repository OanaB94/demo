package com.project.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class SubjectNotFoundException extends RuntimeException{
    private static final String MESSAGE = "Subject not found for id";
    public SubjectNotFoundException(Integer id) {
        super(MESSAGE + id);
    }
}
