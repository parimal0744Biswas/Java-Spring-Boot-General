package com.parimal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parimal.exception.CourseException;
import com.parimal.model.Course;
import com.parimal.repository.CourseDao;

@Service
public class CourseServiceImpl implements CourseService
{
	@Autowired
	private CourseDao cDao;

	@Override
	public List<Course> getallCourse() throws CourseException
	{
		return cDao.findAll();

	}

	@Override
	public String addCourse(Course course) throws CourseException
	{
		Course registerCourse = cDao.save(course);

		return registerCourse.getCName() + " is Registed Sussfully........";

	}

	@Override
	public Course updateCourse(Course course) throws CourseException
	{
		Course existCourse = cDao.findById(course.getCId()).orElseThrow(() -> new CourseException("Course Not Found"));

		existCourse.setCName(course.getCName());
		existCourse.setCFee(course.getCFee());

		return cDao.save(existCourse);
	}

	@Override
	public Course deleteCourse(String cname) throws CourseException
	{

		List<Course> courses = cDao.deleteBycName(cname);

		if (courses.isEmpty())
		{
			throw new CourseException("Course not found");
		}

		return courses.get(0);

//		Course course = cDao.findBycName(cname).get(0);
//
//		if (course == null)
//		{
//			throw new CourseException("Course Not FOund ");
//		}
//
//		cDao.delete(course);
//
//		return course;
	}

}
