package com.project.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TeacherNotFoundException extends RuntimeException{

    private static final String MESSAGE = "Teacher not found for id ";
    public TeacherNotFoundException(Integer id) {
        super(MESSAGE + id);
    }
}
