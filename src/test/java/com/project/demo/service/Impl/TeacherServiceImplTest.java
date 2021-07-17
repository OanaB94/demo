package com.project.demo.service.Impl;

import com.project.demo.adapter.TeacherAdapter;
import com.project.demo.dao.TeacherRepository;
import com.project.demo.entity.Teacher;
import com.project.demo.model.TeacherDTO;
import com.project.demo.service.TeacherService;
import com.project.demo.validation.TeacherValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TeacherServiceImplTest {

    @Mock
    private TeacherRepository teacherRepository;

    private TeacherAdapter teacherAdapter;
    private TeacherValidator validateTeacher;
    private TeacherService teacherService;

    private TeacherDTO teacherDTO;
    private Teacher teacher;

    public TeacherServiceImplTest() {
        this.teacherAdapter = new TeacherAdapter();
        this.validateTeacher = new TeacherValidator();
        this.teacherService = new TeacherServiceImpl(teacherRepository, teacherAdapter, validateTeacher);
    }

    @BeforeEach
//    public void init() {
//        teacher = Teacher.builder()
//                .id(1)
//                .name("Popescu")
//                .surname("Vasile")
//                .dateOfBirth(new Date())
//                .dateOfEmployment(new Date())
//                .phone("0752501132")
//                .build();
//        teacherDTO = TeacherDTO.builder()
//                .id(1)
//                .name("Popescu")
//                .surname("Vasile")
//                .dateOfBirth(new Date())
//                .dateOfEmployment(new Date())
//                .phone("0752501132")
//                .build();
//    }

    @Test
    public void findByIdValid_Test() {
        Integer id = 1;
        Mockito.when(teacherRepository.findById(1)).thenReturn(Optional.ofNullable(teacher));
    }
}