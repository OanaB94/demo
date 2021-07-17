package com.project.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String description;

    //mai multe materii la un profesor
    @ManyToOne
    @JoinColumn(name = "idteacher")
    private Teacher teacher;

}

