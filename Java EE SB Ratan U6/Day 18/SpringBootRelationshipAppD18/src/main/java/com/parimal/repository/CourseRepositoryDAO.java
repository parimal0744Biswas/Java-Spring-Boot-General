package com.parimal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parimal.model.Course;

@Repository
public interface CourseRepositoryDAO extends JpaRepository<Course, Integer>
{

	public List<Course> findByCourseName(String course);

	@Query("from Course where courseName=?1")
	public Course getCourseByCourseName(String course);

}
