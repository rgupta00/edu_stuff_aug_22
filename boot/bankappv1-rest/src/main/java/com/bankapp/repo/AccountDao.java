package com.bankapp.repo;

import java.util.List;

import com.bankapp.entity.Account;

public interface AccountDao {
	public List<Account> getAll();

	public Account getById(int id);

	public Account updateAccount(Account account);

	public Account addAccount(Account account);

	public void deleteAccount(int id);
}
