package com.project.demo.controller;

import com.project.demo.entity.Subject;
import com.project.demo.model.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.demo.service.SubjectService;

import java.util.List;

@RestController
public class SubjectController {
    SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @CrossOrigin
    @GetMapping("/subject/{id}")
    public ResponseEntity<SubjectDTO> retrieveSubjectById(@PathVariable Integer id) {
        return ResponseEntity.ok(subjectService.findById(id));
    }

    @CrossOrigin
    @GetMapping("/subject")
    public List<SubjectDTO> retrieveAll() {
        return subjectService.findAll();
    }

    @CrossOrigin
    @PostMapping("/subject")
    public ResponseEntity<?> createSubject(@RequestBody SubjectDTO subjectDTO) {
        subjectService.createSubject(subjectDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @CrossOrigin
    @PutMapping("/subject/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable Integer id, @RequestBody SubjectDTO subjectDTO) {
        subjectService.updateSubject(id, subjectDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @CrossOrigin
    @DeleteMapping("/subject/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable Integer id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
