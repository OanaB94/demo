package com.project.demo.controller;

import com.project.demo.model.TeacherDTO;
import com.project.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @CrossOrigin
    @GetMapping("/teacher/{id}")
    public TeacherDTO retrieveTeacherById(@PathVariable Integer id) {
        return teacherService.findById(id);
    }

    @CrossOrigin
    @GetMapping("/teacher")
    public List<TeacherDTO> retrieveAll() {
        return teacherService.findAll();
    }

    @CrossOrigin
    @PostMapping("/teacher")
    public ResponseEntity<?> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        teacherService.createTeacher(teacherDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @CrossOrigin
    @PutMapping("/teacher/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @RequestBody TeacherDTO teacherDTO) {
        teacherService.updateTeacher(id, teacherDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @CrossOrigin
    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
