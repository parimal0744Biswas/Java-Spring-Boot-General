package com.parimal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parimal.exception.CourseException;
import com.parimal.exception.StudentException;
import com.parimal.model.Student;
import com.parimal.service.StudentServiceDAOImpl;

@RestController
public class StudentController
{
	@Autowired
	private StudentServiceDAOImpl sServive;

	@PostMapping("/savestudent/{cname}")
	public ResponseEntity<Student> saveCourseHandler(@PathVariable("cname") String coursename,
			@RequestBody Student student) throws StudentException, CourseException
	{
		Student savedstudent = sServive.registerStudentInCourse(coursename, student);

		return new ResponseEntity<Student>(savedstudent, HttpStatus.CREATED);

	}

}
