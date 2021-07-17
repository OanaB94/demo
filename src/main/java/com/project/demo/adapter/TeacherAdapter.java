package com.project.demo.adapter;

import com.project.demo.entity.Subject;
import com.project.demo.entity.Teacher;
import com.project.demo.exception.MissingInputException;
import com.project.demo.model.TeacherDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherAdapter {

    private List<String> getSubjectNames(List<Subject> subjects) {
        List<String> names = new ArrayList<>();
        for(Subject subject : subjects) {
            names.add(subject.getName());
        }
        return names;
    }

    public TeacherDTO fromEntityToDTO(Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacher.getId());
        teacherDTO.setName(teacher.getName());
        teacherDTO.setSurname(teacher.getSurname());
        teacherDTO.setDateOfBirth(teacher.getDateOfBirth());
        teacherDTO.setDateOfEmployment(teacher.getDateOfEmployment());
        teacherDTO.setPhone(teacher.getPhone());
        teacherDTO.setSubjects(getSubjectNames(teacher.getSubjectList()));

        return teacherDTO;
    }

    public Teacher fromDTOtoEntity(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setName(teacherDTO.getName());
        teacher.setSurname(teacherDTO.getSurname());
        teacher.setDateOfBirth(teacherDTO.getDateOfBirth());
        teacher.setDateOfEmployment(teacherDTO.getDateOfEmployment());
        teacher.setPhone(teacherDTO.getPhone());
        return teacher;
    }

    public List<TeacherDTO> fromListEntitytoListDTO(Iterable<Teacher> teacherList) {
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for(Teacher teacher : teacherList) {
            teacherDTOList.add(fromEntityToDTO(teacher));
        }
        return teacherDTOList;
    }


}
