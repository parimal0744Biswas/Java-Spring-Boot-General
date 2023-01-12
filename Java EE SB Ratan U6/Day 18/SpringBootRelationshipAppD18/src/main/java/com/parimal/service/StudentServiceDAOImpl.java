package com.parimal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parimal.exception.CourseException;
import com.parimal.exception.StudentException;
import com.parimal.model.Course;
import com.parimal.model.Student;
import com.parimal.repository.CourseRepositoryDAO;
import com.parimal.repository.StudentRepositoryDAO;

@Service
public class StudentServiceDAOImpl implements StudentServiceDAO
{
	@Autowired
	private StudentRepositoryDAO sRepo;

	@Autowired
	private CourseRepositoryDAO cRepo;

	@Override
	public Student registerStudentInCourse(String couesename, Student student) throws StudentException, CourseException
	{
		// TODO Auto-generated method stub

		List<Course> listcourse = cRepo.findByCourseName(couesename);

		if (listcourse.size() == 0)
		{
			throw new CourseException("Course not found with name " + couesename);
		}

		Course course = null;
		for (Course el : listcourse)
		{
			course = el;

		}

		course.getStudentset().add(student);
		student.getCourseset().add(course);

		return sRepo.save(student);
	}

}
