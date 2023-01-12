package com.parimal.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roll;

	private String name;

	private Integer marks;

	@Embedded
	private Address address;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Course> courseset = new HashSet<>();

	public Student()
	{
		// TODO Auto-generated constructor stub
	}

	public Student(String name, Integer marks, Address address, Set<Course> courseset)
	{
		super();
		this.name = name;
		this.marks = marks;
		this.address = address;
		this.courseset = courseset;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(address, marks, name, roll);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && Objects.equals(marks, other.marks)
				&& Objects.equals(name, other.name) && Objects.equals(roll, other.roll);
	}

	public Integer getRoll()
	{
		return roll;
	}

	public void setRoll(Integer roll)
	{
		this.roll = roll;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getMarks()
	{
		return marks;
	}

	public void setMarks(Integer marks)
	{
		this.marks = marks;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public Set<Course> getCourseset()
	{
		return courseset;
	}

	public void setCourseset(Set<Course> courseset)
	{
		this.courseset = courseset;
	}

}
