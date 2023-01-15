package com.parimal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parimal.exception.CusromerException;
import com.parimal.model.Customer;

@Service
public interface CustomerService
{
	public Customer registerCustomer(Customer customer) throws CusromerException;

	public List<Customer> viewAllCustomer() throws CusromerException;

	public Customer updateCustomer(Customer customer) throws CusromerException;

	public Customer deleteCustomer(Integer cId) throws CusromerException;

}
