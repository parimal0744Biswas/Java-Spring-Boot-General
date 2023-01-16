package com.parimal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parimal.exception.CusromerException;
import com.parimal.model.Customer;
import com.parimal.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerDao cDao;

	@Override
	public Customer registerCustomer(Customer customer) throws CusromerException
	{
		// cDao.findById(customer.getCId()).orElseThrow(() -> new
		// CusromerException("Customer already Exists"));

		return cDao.save(customer);

	}

	@Override
	public List<Customer> viewAllCustomer() throws CusromerException
	{
		return cDao.findAll();

	}

	@Override
	public Customer updateCustomer(Customer customer) throws CusromerException
	{
		List<Customer> existcustomers = cDao.findAll().stream().filter(s -> s.getCId() == customer.getCId())
				.collect(Collectors.toList());

		if (existcustomers.isEmpty())
		{
			throw new CusromerException("Customer not Exists");
		}

		Customer finalCustomer = existcustomers.get(0);

		finalCustomer.setCName(customer.getCName());

		return cDao.save(finalCustomer);
	}

	@Override
	public Customer deleteCustomer(Integer cId) throws CusromerException
	{
		List<Customer> existcustomers = cDao.findAll().stream().filter(s -> s.getCId() == cId)
				.collect(Collectors.toList());

		if (existcustomers.isEmpty())
		{
			throw new CusromerException("Customer not Exists");
		}

		Customer finalCustomer = existcustomers.get(0);

		cDao.delete(finalCustomer);

		return finalCustomer;

	}

}
