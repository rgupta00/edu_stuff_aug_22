package com.bankapp.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
//<bean id="accountDao2" class="com.bankapp.model.dao.AccountDaoImplJdbc"/>
@Repository(value = "accountDao2")
@Profile("preprod")
//@Primary
public class AccountDaoImplJdbc implements AccountDao {
	private Map<Integer, Account> accounts = new HashMap<>();

	public AccountDaoImplJdbc() {
		accounts.put(1, new Account(1, "raj", 560000.00));
		accounts.put(2, new Account(2, "ekta", 760000.00));
	}

	@Override
	public List<Account> getAll() {
		System.out.println("get all using jdbc");
		return new ArrayList<Account>(accounts.values());
	}

	@Override
	public Account getById(int id) {
		System.out.println("get by id by jdbc");
		return accounts.get(id);
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
