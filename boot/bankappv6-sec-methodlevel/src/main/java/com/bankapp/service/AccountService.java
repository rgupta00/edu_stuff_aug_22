package com.bankapp.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.bankapp.entity.Account;

public interface AccountService {
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Account> getAll();
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Account getById(int id);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public void deleteAccount(int id);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Account updateAccount(Account account);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Account createAccount(Account account);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MGR')")
	public void transfer(int fromAccId, int toAccId, double amount);
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MGR')")
	public void withdraw(int accId, double amount);
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MGR')")
	public void deposit(int accId, double amount);
}
