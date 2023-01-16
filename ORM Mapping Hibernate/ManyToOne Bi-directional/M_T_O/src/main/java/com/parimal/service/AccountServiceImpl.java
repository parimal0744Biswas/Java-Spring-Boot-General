package com.parimal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parimal.exception.AccountException;
import com.parimal.exception.CusromerException;
import com.parimal.model.Account;
import com.parimal.model.Customer;
import com.parimal.repository.AccountDao;
import com.parimal.repository.CustomerDao;

@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountDao aDao;

	@Autowired
	private CustomerDao cDao;

	@Override
	public Account openAccount(Account account) throws AccountException
	{
		return aDao.save(account);

	}

	@Override
	public List<Account> viewAllAccountsOfCustomer(Integer cId) throws AccountException, CusromerException
	{
		Customer customer = cDao.findById(cId).orElseThrow(() -> new CusromerException("Customer Not Found"));

		return customer.getAccounts();
	}

	@Override
	public Account updateAccount(Account account) throws AccountException
	{
		Account existAccount = aDao.findById(account.getAccNo())
				.orElseThrow(() -> new AccountException("No account Found"));

		existAccount.setBankName(account.getBankName());
		existAccount.setABalance(account.getABalance());

		return aDao.save(existAccount);
	}

	@Override
	public Account deleteAccount(Integer accNo) throws AccountException
	{
		// TODO Auto-generated method stub
		Account existAccount = aDao.findById(accNo).orElseThrow(() -> new AccountException("No account Found"));

		Customer customer = existAccount.getCustomer();

		customer.getAccounts().remove(existAccount);

		aDao.delete(existAccount);

		cDao.save(customer);

		return existAccount;
	}

}
