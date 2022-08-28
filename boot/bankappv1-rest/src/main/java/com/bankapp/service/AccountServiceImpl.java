package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.entity.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountDao;
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

	@Override
	public Account createAccount(Account account) {
		return accountDao.addAccount(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return accountDao.updateAccount(account);
	}



}
