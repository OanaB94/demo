package com.project.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MissingInputException extends RuntimeException{
    public MissingInputException(String message) {
        super(message);
    }
}
