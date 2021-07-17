package com.project.demo.service;

import java.util.List;
import com.project.demo.model.TeacherDTO;

public interface TeacherService {
    TeacherDTO findById(Integer id);
    List<TeacherDTO> findAll();
    void createTeacher(TeacherDTO teacherDTO);
    void updateTeacher(Integer id, TeacherDTO teacherDTO);
    void deleteTeacher(Integer id);
}
