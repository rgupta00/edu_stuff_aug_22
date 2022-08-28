package com.bankapp.service;

import java.util.List;

import com.bankapp.entity.Account;

public interface AccountService {
	public List<Account> getAll();
	public Account getById(int id);
	public void deleteAccount(int id);
	public Account updateAccount(Account account);
	public Account createAccount(Account account);
	public void transfer(int fromAccId, int toAccId, double amount);
	public void withdraw(int accId, double amount);
	public void deposit(int accId, double amount);
}
