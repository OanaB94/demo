package com.project.demo;

import com.project.demo.dao.SubjectRepository;
import com.project.demo.dao.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplicationTests.class, args);
//	}

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Test
	void contextLoads() {
	}


}
