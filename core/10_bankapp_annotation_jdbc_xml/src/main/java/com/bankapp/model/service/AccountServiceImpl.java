package com.bankapp.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.exceptions.MyEx;
import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;
import com.bankapp.util.MyLogger;
//@Transactional(isolation = Isolation.READ_COMMITTED,noRollbackFor = {MyEx.class} )
@Transactional
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Override
	public Account getById(int id) {
		Account account= accountDao.getById(id);
		if(account==null)
			throw new BankAccountNotFoundException("account with id "+ id + " is not found");
		return account;
	}

	@Override
	public void deleteAccount(int id) {
		accountDao.deleteAccount(id);
	}

	@MyLogger
	@Override
	public void transfer(int fromAccId, int toAccId, double amount) {
		Account fromAccount = getById(fromAccId);
		Account toAccount = getById(toAccId);

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountDao.updateAccount(fromAccount);
		
		if(1==1)
			throw new MyEx();
		
		accountDao.updateAccount(toAccount);
	}

	@Override
	public void withdraw(int accId, double amount) {
		Account account = getById(accId);
		account.setBalance(account.getBalance() - amount);
		accountDao.updateAccount(account);
	}

	@Override
	public void deposit(int accId, double amount) {
		Account account = getById(accId);
		account.setBalance(account.getBalance() + amount);
		accountDao.updateAccount(account);
	}

}
