package com.project.demo.model;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class TeacherDTO {
    private Integer id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private Date dateOfEmployment;
    private String phone;
    private List<String> subjects;
}
