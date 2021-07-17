package com.project.demo.validation;

import com.project.demo.exception.InvalidInputException;
import com.project.demo.exception.MissingInputException;
import com.project.demo.model.TeacherDTO;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class TeacherValidator {

    public boolean validate(TeacherDTO teacherDTO) {
        return validateEmpty(teacherDTO) && validateFields(teacherDTO);
    }

    private boolean validateEmpty(TeacherDTO teacherDTO) {
        if (teacherDTO.getName() == null) {
            throw new MissingInputException("name must not be empty");
        }

        if (teacherDTO.getSurname() == null) {
            throw new MissingInputException("surname must not be empty");
        }

        if (teacherDTO.getDateOfBirth() == null) {
            throw new MissingInputException("date of birth must not be empty");
        }

        if (teacherDTO.getDateOfEmployment() == null) {
            throw new MissingInputException("date of employment must not be empty");
        }

        if (teacherDTO.getPhone() == null) {
            throw new MissingInputException("phone must not be empty");
        }
        return true;
    }

    private boolean validateFields(TeacherDTO teacherDTO){
        return isValidDate(teacherDTO) &&
                isValidPhone(teacherDTO) &&
                isValidNameSurname(teacherDTO);

    }
    private boolean isValidDate(TeacherDTO teacherDTO) {
        Date currentDate = new Date();
        if (teacherDTO.getDateOfBirth().after(currentDate)) {
            throw new InvalidInputException("dateOfBirth cannot be after the current date");
        }
        if (teacherDTO.getDateOfEmployment().before(currentDate) ) {
            throw new InvalidInputException("dateOfEmployment may be today or in the future");
        }
        return true;
    }

    private boolean isValidPhone(TeacherDTO teacherDTO) {
        //matches 10 or 11 -digit numbers only
        //to do check if +
        String regexStr = "^[0-9]{10,11}$";

        String phone = teacherDTO.getPhone();
        if(phone.startsWith("+")){
            phone = phone.replace("+", "");
        }

        if (!phone.matches(regexStr)) {
            throw new InvalidInputException("invalid phone");
        }
        return true;
    }

    private boolean isValidNameSurname(TeacherDTO teacherDTO) {
        String regexStr = "^[a-zA-Z\\s-]*$" ;
        if(!teacherDTO.getName().matches(regexStr) || !teacherDTO.getSurname().matches(regexStr)) {
            throw new InvalidInputException("invalid name or surname");
        }
        return true;
    }

//    private boolean isBirthBeforeEmployment(TeacherDTO teacherDTO) {
//        Integer value = 18;
//        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
//        Date date = originalFormat.parse(value.toString());
//
//        Date currentDate = new Date();
//
//        if(teacherDTO.getDateOfBirth().before(teacherDTO.getDateOfEmployment()) && ){
//
//        }
    }





