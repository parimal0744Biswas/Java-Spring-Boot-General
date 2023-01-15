package com.parimal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parimal.exception.StudentException;
import com.parimal.model.Course;
import com.parimal.model.Student;
import com.parimal.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService
{

	@Autowired
	private StudentDao sDao;

	@Override
	public List<Student> getallStudent() throws StudentException
	{
		return sDao.findAll();

	}

	@Override
	public String addStudent(Student student) throws StudentException
	{
		List<Student> alreadyStudent = sDao.findAll().stream().filter(s -> s.getSName().equals(student.getSName()))
				.collect(Collectors.toList());

		if (alreadyStudent.size() == 0)
		{
			return sDao.save(student).getSName() + " Added Sussfully....";
		}
		else
		{
			throw new StudentException("Student alreafy found...");
		}

	}

	@Override
	public Student updateStudent(Student student) throws StudentException
	{
		Student registerdstudent = sDao.findById(student.getSId())
				.orElseThrow(() -> new StudentException("Student not found..."));

		registerdstudent.setSName(student.getSName());
		registerdstudent.setSPassword(student.getSPassword());

		return sDao.save(registerdstudent);
	}

	@Override
	public Student deleteStudent(Integer sId) throws StudentException
	{
		Student student = sDao.findById(sId).orElseThrow(() -> new StudentException("Student not found..."));

		sDao.delete(student);

		return student;
	}

	@Override
	public List<Course> enrollCourse(String cname) throws StudentException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
