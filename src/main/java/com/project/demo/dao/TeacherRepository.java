package com.project.demo.dao;

import com.project.demo.entity.Teacher;
import org.springframework.data.repository.CrudRepository;


public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}
