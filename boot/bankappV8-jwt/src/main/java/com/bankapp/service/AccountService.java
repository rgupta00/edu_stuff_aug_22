package com.bankapp.service;

import java.util.List;

import com.bankapp.dto.AccountDetailDto;
import com.bankapp.entities.Account;

public interface AccountService {
	
	public List<Account> getAll();
	public Account getById(int id);
	public Account addAccount(Account account);
	public Account deleteAccount(int id);
	
	public Account updateAccount(int id, AccountDetailDto accountDetailDto);
	
	public void transfer(int fromId, int toId, double amount);
	public void deposit(int id,  double amount);
	public void withdraw(int id, double amount);
}
