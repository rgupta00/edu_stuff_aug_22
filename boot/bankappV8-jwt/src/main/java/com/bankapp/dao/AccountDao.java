package com.bankapp.dao;
import java.util.*;

import com.bankapp.entities.Account;

public interface AccountDao {
	public List<Account> getAll();
	public Account getById(int id);
	public void updateAccount(Account account);
	public Account addAccount(Account account);
	public Account deleteAccount(int id);
}
