package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Product;
import com.entity.Student;

public class Demo
{

	public static void main(String[] args)
	{
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("studentUnit");
		EntityManager em1 = emf1.createEntityManager();

		Student student = new Student("mmmm", 2563);
		Product product = new Product("ggggggg", 250);

		em1.getTransaction().begin();

		em1.persist(student);
		em1.persist(product);

		em1.getTransaction().commit();

		em1.close();

		System.out.println("Done");
	}

}
