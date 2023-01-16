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

import com.parimal.exception.AccountException;
import com.parimal.exception.CusromerException;
import com.parimal.model.Account;
import com.parimal.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController
{
	@Autowired
	private AccountService aService;

	@PostMapping("/create")
	public ResponseEntity<Account> openAccount(@RequestBody Account account) throws AccountException
	{
		
		return new ResponseEntity<Account>(aService.openAccount(account), HttpStatus.CREATED);
	}

	@GetMapping("/view/{cid}")
	public ResponseEntity<List<Account>> viewAllAccountsOfCustomer(@PathVariable("cid") Integer cId)
			throws AccountException, CusromerException
	{
		return new ResponseEntity<List<Account>>(aService.viewAllAccountsOfCustomer(cId), HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account) throws AccountException
	{
		return new ResponseEntity<Account>(aService.updateAccount(account), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{accNo}")
	public ResponseEntity<Account> deleteAccount(@PathVariable("accNo") Integer accNo) throws AccountException
	{
		return new ResponseEntity<Account>(aService.deleteAccount(accNo), HttpStatus.OK);
	}

}
