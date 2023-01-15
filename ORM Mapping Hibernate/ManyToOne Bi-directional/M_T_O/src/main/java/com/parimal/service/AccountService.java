package com.parimal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parimal.exception.AccountException;
import com.parimal.exception.CusromerException;
import com.parimal.model.Account;

@Service
public interface AccountService
{

	public Account openAccount(Account account) throws AccountException;

	public List<Account> viewAllAccountsOfCustomer(Integer cId) throws AccountException, CusromerException;

	public Account updateAccount(Account account) throws AccountException;

	public Account deleteAccount(Integer accNo) throws AccountException;
}
