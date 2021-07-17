package com.project.demo.adapter;

import com.project.demo.entity.Subject;
import com.project.demo.model.SubjectDTO;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SubjectAdapter {
    public SubjectDTO fromEntitytoDTO(Subject subject) {

        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(subject.getId());
        if (subject.getTeacher() != null) {
            subjectDTO.setTeacherName(subject.getTeacher().getName() + " "
                    + subject.getTeacher().getSurname());
            subjectDTO.setIdTeacher(subject.getTeacher().getId());
        }
        subjectDTO.setName(subject.getName());
        subjectDTO.setDescription(subject.getDescription());


        return subjectDTO;
    }

    public Subject fromDTOtoEntity(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setId(subjectDTO.getId());
        subject.setName(subjectDTO.getName());
        subject.setDescription(subjectDTO.getDescription());

        return subject;
    }

    public List<SubjectDTO> fromListEntityToListDTO(Iterable<Subject> subjectList) {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        for(Subject subject : subjectList) {
            subjectDTOList.add(fromEntitytoDTO(subject));
        }
        return subjectDTOList;
    }

    public List<Subject> fromListDTO (List<SubjectDTO> subjectDTOList) {
        List<Subject> subjectList = new ArrayList<>();
        for(SubjectDTO subjectDTO : subjectDTOList) {
            subjectList.add(fromDTOtoEntity(subjectDTO));
        }
        return subjectList;
    }
}
