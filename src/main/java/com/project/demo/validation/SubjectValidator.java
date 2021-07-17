package com.project.demo.validation;

import com.project.demo.exception.InvalidInputException;
import com.project.demo.exception.MissingInputException;
import com.project.demo.model.SubjectDTO;
import org.springframework.stereotype.Component;

@Component
public class SubjectValidator {

    public boolean validate(SubjectDTO subjectDTO) {
        return validateEmpty(subjectDTO) && isValidNameDescription(subjectDTO);
    }

    private boolean validateEmpty(SubjectDTO subjectDTO) {
        if (subjectDTO.getName() == null) {
            throw new MissingInputException("name must not be empty");
        }

        if (subjectDTO.getDescription() == null) {
            throw new MissingInputException("description must not be empty");
        }
        return true;
    }

    private boolean isValidNameDescription(SubjectDTO subjectDTO) {
        String regexStr = "^[a-zA-Z\\s]*$";
        if (!subjectDTO.getName().matches(regexStr) || !subjectDTO.getDescription().matches(regexStr)) {
            throw new InvalidInputException("invalid name or description");
        }
        return true;
    }
}