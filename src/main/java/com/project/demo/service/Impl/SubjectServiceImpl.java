package com.project.demo.service.Impl;

import com.project.demo.adapter.SubjectAdapter;
import com.project.demo.dao.SubjectRepository;
import com.project.demo.dao.TeacherRepository;
import com.project.demo.entity.Subject;
import com.project.demo.entity.Teacher;
import com.project.demo.exception.SubjectNotFoundException;
import com.project.demo.exception.TeacherNotFoundException;
import com.project.demo.model.SubjectDTO;
import com.project.demo.service.SubjectService;
import com.project.demo.validation.SubjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;
    private TeacherRepository teacherRepository;
    private SubjectAdapter subjectAdapter;
    private SubjectValidator subjectValidator;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository, TeacherRepository teacherRepository, SubjectAdapter subjectAdapter, SubjectValidator subjectValidator) {
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
        this.subjectAdapter = subjectAdapter;
        this.subjectValidator = subjectValidator;
    }

    @Override
    public SubjectDTO findById(Integer id) {
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        if (subjectOptional.isPresent()) {
            return subjectAdapter.fromEntitytoDTO(subjectOptional.get());
        } else {
            throw new SubjectNotFoundException(id);
        }
    }

    @Override
    public List<SubjectDTO> findAll() {
        Iterable<Subject> subjectList = subjectRepository.findAll();
        return subjectAdapter.fromListEntityToListDTO(subjectList);
    }

    @Override
    public void createSubject(SubjectDTO subjectDTO) {
        if (subjectValidator.validate(subjectDTO)) {
            Optional<Teacher> teacherOptional = teacherRepository.findById(subjectDTO.getIdTeacher());
            if(teacherOptional.isPresent()) {
                Subject subject = subjectAdapter.fromDTOtoEntity(subjectDTO);
                subject.setTeacher(teacherOptional.get());
                subjectRepository.save(subject);
            } else {
                throw new TeacherNotFoundException(subjectDTO.getIdTeacher());
            }
        }
    }

    @Override
    public void updateSubject(Integer id, SubjectDTO subjectDTO) {
        if (subjectValidator.validate(subjectDTO) && subjectRepository.existsById(id)) {
            Optional<Teacher> teacherOptional = teacherRepository.findById(subjectDTO.getIdTeacher());
            if(teacherOptional.isPresent()) {
                Subject subject = subjectAdapter.fromDTOtoEntity(subjectDTO);
                subject.setId(id);
                subject.setTeacher(teacherOptional.get());
                subjectRepository.save(subject);
            } else {
                throw new TeacherNotFoundException(subjectDTO.getIdTeacher());
            }
        } else {
            throw new SubjectNotFoundException(id);
        }
    }

    @Override
    public void deleteSubject(Integer id){
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
        } else {
            throw new SubjectNotFoundException(id);
        }
    }
}
