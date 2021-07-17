package com.project.demo.service;

import java.util.List;
import com.project.demo.model.SubjectDTO;

public interface SubjectService {
    SubjectDTO findById(Integer id);
    List<SubjectDTO> findAll();
    void createSubject(SubjectDTO subjectDTO);
    void updateSubject(Integer id, SubjectDTO subjectDTO);
    void deleteSubject(Integer id);
}
