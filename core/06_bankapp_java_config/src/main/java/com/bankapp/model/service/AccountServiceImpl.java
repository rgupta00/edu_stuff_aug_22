package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;

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
		return accountDao.getById(id);
	}

	@Override
	public void deleteAccount(int id) {
		accountDao.deleteAccount(id);
	}

	@Override
	public void transfer(int fromAccId, int toAccId, double amount) {
		Account fromAccount = accountDao.getById(fromAccId);
		Account toAccount = accountDao.getById(toAccId);

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountDao.updateAccount(fromAccount);
		accountDao.updateAccount(toAccount);
	}

	@Override
	public void withdraw(int accId, double amount) {
		Account account = accountDao.getById(accId);
		account.setBalance(account.getBalance() - amount);
		accountDao.updateAccount(account);
	}

	@Override
	public void deposit(int accId, double amount) {
		Account account = accountDao.getById(accId);
		account.setBalance(account.getBalance() + amount);
		accountDao.updateAccount(account);
	}

}
