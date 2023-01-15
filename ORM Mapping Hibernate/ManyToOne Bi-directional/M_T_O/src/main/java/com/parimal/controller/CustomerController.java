package com.parimal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parimal.exception.CusromerException;
import com.parimal.model.Customer;
import com.parimal.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
	@Autowired
	private CustomerService cService;

	@PostMapping("/create")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) throws CusromerException
	{
		return new ResponseEntity<Customer>(cService.registerCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping("/view")
	public ResponseEntity<List<Customer>> viewAllCustomer() throws CusromerException
	{
		return new ResponseEntity<List<Customer>>(cService.viewAllCustomer(), HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CusromerException
	{
		return new ResponseEntity<Customer>(cService.updateCustomer(customer), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{cId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("cId") Integer cId) throws CusromerException
	{
		return new ResponseEntity<Customer>(cService.deleteCustomer(cId), HttpStatus.OK);
	}

}
