package com.bankapp.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bankapp.exceptions.BankAccountNotFoundException;
//<bean id="accountDao1" class="com.bankapp.model.dao.AccountDaoImplMap"/>
@Repository(value = "accountDao1")
public class AccountDaoImplMap implements AccountDao {
	private Map<Integer, Account> accounts = new HashMap<>();

	public AccountDaoImplMap() {
		accounts.put(1, new Account(1, "raj", 1000.00));
		accounts.put(2, new Account(2, "ekta", 1000.00));
	}

	@Override
	public List<Account> getAll() {
		System.out.println("get all using hashmap");
		return new ArrayList<Account>(accounts.values());
	}

	@Override
	public Account getById(int id) {
		Account account= accounts.get(id);
		if(account==null)
			throw new BankAccountNotFoundException("account with id "+ id +" is not found");
		
		return account;
	}

	@Override
	public void updateAccount(Account account) {
		accounts.put(account.getId(), account);
	}

	@Override
	public void addAccount(Account account) {

	}

	@Override
	public void deleteAccount(int id) {

	}

}
