package com.bankapp.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.entity.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private EntityManager em;//Hibernate session
	
	@Override
	public List<Account> getAll() {
		return em.createQuery("select a from Account a", Account.class).getResultList();
	}

	@Override
	public Account getById(int id) {
		return em.find(Account.class, id);
	}

	@Override
	public Account updateAccount(Account account) {
		em.merge(account);
		return account;
	}

	@Override
	public Account addAccount(Account account) {
		 em.persist(account);
		 return account;
	}

	@Override
	public void deleteAccount(int id) {
		Account accountToDelete= getById(id);
		em.remove(accountToDelete);
	}

}
