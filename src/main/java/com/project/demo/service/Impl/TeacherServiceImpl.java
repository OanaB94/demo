package com.project.demo.service.Impl;

import com.project.demo.adapter.TeacherAdapter;
import com.project.demo.dao.TeacherRepository;
import com.project.demo.entity.Teacher;
import com.project.demo.exception.TeacherNotFoundException;
import com.project.demo.model.TeacherDTO;
import com.project.demo.service.TeacherService;
import com.project.demo.validation.TeacherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    private TeacherAdapter teacherAdapter;
    private TeacherValidator teacherValidator;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherAdapter teacherAdapter,
                              TeacherValidator teacherValidator) {
        this.teacherRepository = teacherRepository;
        this.teacherAdapter = teacherAdapter;
        this.teacherValidator = teacherValidator;
    }

    @Override
    public TeacherDTO findById(Integer id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if(teacherOptional.isPresent()) {
            return teacherAdapter.fromEntityToDTO(teacherOptional.get());
        } else {
            throw new TeacherNotFoundException(id);
        }
    }

    @Override
    public List<TeacherDTO> findAll() {
        Iterable<Teacher> teacherList = teacherRepository.findAll();
        return teacherAdapter.fromListEntitytoListDTO(teacherList);
    }

    @Override
    public void createTeacher(TeacherDTO teacherDTO) {
        if(teacherValidator.validate(teacherDTO)) {
            Teacher teacher = teacherAdapter.fromDTOtoEntity(teacherDTO);
            teacherRepository.save(teacher);
        }
    }

    @Override
    public void updateTeacher(Integer id, TeacherDTO teacherDTO) {
        if(teacherValidator.validate(teacherDTO) && teacherRepository.existsById(id)) {
            teacherDTO.setId(id);
            Teacher teacher = teacherAdapter.fromDTOtoEntity(teacherDTO);
            teacherRepository.save(teacher);
        } else {
            throw new TeacherNotFoundException(id);
        }
    }

    @Override
    public void deleteTeacher(Integer id) {
        if(teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
        } else {
            throw new TeacherNotFoundException(id);
        }
    }
}
