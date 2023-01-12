package com.parimal.service;

import com.parimal.exception.CourseException;
import com.parimal.exception.StudentException;
import com.parimal.model.Student;

public interface StudentServiceDAO
{
	public Student registerStudentInCourse(String couesename, Student student) throws StudentException, CourseException;

}
