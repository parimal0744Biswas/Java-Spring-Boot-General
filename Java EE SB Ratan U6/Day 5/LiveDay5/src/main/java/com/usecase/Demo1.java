package com.usecase;

import javax.persistence.EntityManager;

import com.model.Address;
import com.model.Employee;
import com.util.EMUtil;

public class Demo1
{
	public static void main(String[] args)
	{
		EntityManager em1 = EMUtil.provideEntityManager();

		Employee employee = new Employee();

		employee.setName("Buro");

		employee.setSalary(8000);

		employee.setHomeAddress(new Address("WB", "HWH", "711107"));

		employee.setOfficeaddress(new Address("KA", "BLR", "33520"));

		em1.getTransaction().begin();

		em1.persist(employee);

		em1.getTransaction().commit();

		em1.close();

		System.out.println("Done");

	}
}
