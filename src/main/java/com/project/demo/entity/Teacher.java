package com.project.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String phone;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Temporal(TemporalType.DATE)
    private Date dateOfEmployment;

    //un profesor la mai multe materii
    @OneToMany(mappedBy = "teacher")
    List<Subject> subjectList;


}
