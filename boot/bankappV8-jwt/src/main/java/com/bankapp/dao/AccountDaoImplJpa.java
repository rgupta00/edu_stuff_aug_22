package com.bankapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.Account;

@Repository
public class AccountDaoImplJpa implements AccountDao {

	private EntityManager em;
	
	@Autowired
	public AccountDaoImplJpa(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Account> getAll() {
		return em.createQuery("select a from Account a", Account.class).getResultList();
	}

	@Override
	public Account getById(int id) {
		return em.find(Account.class, id);
	}

	@Override
	public void updateAccount(Account account) {
		em.merge(account);
	}

	@Override
	public Account addAccount(Account account) {
		em.persist(account);
		return account;
	}

	@Override
	public Account deleteAccount(int id) {
		Account accountToDelete= getById(id);
		if(accountToDelete!=null)
			em.remove(accountToDelete);
		return accountToDelete;
	}

}
