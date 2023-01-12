package com.parimal.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	private String courseName;
	private Integer fee;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "courseset")
	private Set<Student> studentset = new HashSet<>();

	public Course()
	{

	}

	public Course(String courseName, Integer fee, Set<Student> studentset)
	{
		super();
		this.courseName = courseName;
		this.fee = fee;
		this.studentset = studentset;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(courseId, courseName, fee);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Course other = (Course) obj;
		return Objects.equals(courseId, other.courseId) && Objects.equals(courseName, other.courseName)
				&& Objects.equals(fee, other.fee);
	}

	public Integer getCourseId()
	{
		return courseId;
	}

	public void setCourseId(Integer courseId)
	{
		this.courseId = courseId;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	public Integer getFee()
	{
		return fee;
	}

	public void setFee(Integer fee)
	{
		this.fee = fee;
	}

	public Set<Student> getStudentset()
	{
		return studentset;
	}

	public void setStudentset(Set<Student> studentset)
	{
		this.studentset = studentset;
	}

}
