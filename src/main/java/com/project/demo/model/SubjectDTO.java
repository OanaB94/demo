package com.project.demo.model;

import lombok.Data;

@Data
public class SubjectDTO {
    private Integer id;
    private String name;
    private String description;
    private String teacherName;
    private Integer idTeacher;
}
