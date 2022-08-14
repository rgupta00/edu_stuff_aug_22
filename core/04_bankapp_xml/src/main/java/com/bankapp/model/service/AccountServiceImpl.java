package com.bankapp.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;

public class AccountServiceImpl implements AccountService {

	private Logger logger=LoggerFactory.getLogger(AccountServiceImpl.class);
	
	private AccountDao accountDao;
	
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Override
	public Account getById(int id) {
		return accountDao.getById(id);
	}

	@Override
	public void deleteAccount(int id) {
		accountDao.deleteAccount(id);
	}

	@Override
	public void transfer(int fromAccId, int toAccId, double amount) {
		long start=System.currentTimeMillis();
		
		Account fromAccount=accountDao.getById(fromAccId);
		Account toAccount=accountDao.getById(toAccId);
		
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
		
		accountDao.updateAccount(fromAccount);
		accountDao.updateAccount(toAccount);
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {}
		
		long end=System.currentTimeMillis();
		logger.info("time taken for execution of this method is: "+(end-start)+" ms");
	}

	@Override
	public void withdraw(int accId, double amount) {
		Account account=accountDao.getById(accId);
		account.setBalance(account.getBalance()-amount);
		accountDao.updateAccount(account);
	}

	@Override
	public void deposit(int accId, double amount) {
		Account account=accountDao.getById(accId);
		account.setBalance(account.getBalance()+amount);
		accountDao.updateAccount(account);
	}

}
