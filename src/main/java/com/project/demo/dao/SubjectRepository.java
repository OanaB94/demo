package com.project.demo.dao;

import com.project.demo.entity.Subject;
import org.springframework.data.repository.CrudRepository;


public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}
