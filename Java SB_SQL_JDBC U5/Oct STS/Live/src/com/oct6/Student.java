package com.oct6;

public class Student
{
	int roll;
	String name;
	int marks;

	public Student(int roll, String name, int marks)
	{
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString()
	{
		return "Student [roll=" + roll + ", name=" + name + ", marks=" + marks + "]";
	}

}
