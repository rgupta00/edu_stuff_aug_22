package com.bankapp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
@Repository
@Primary
public class AccountDaoImplHib implements AccountDao{

	public SessionFactory sessionFactory;
	
	@Autowired
	public AccountDaoImplHib(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();//hey spring u alreay have configure a session for this current thread give it to me
	}
	@Override
	public List<Account> getAll() {
		return getSession().createQuery("select a from Account a", Account.class).getResultList();
	}

	@Override
	public Account getById(int id) {
		return getSession().get(Account.class, id);
	}

	@Override
	public void updateAccount(Account account) {
		getSession().merge(account);//it is better then update*
	}

	@Override
	public void addAccount(Account account) {
		getSession().save(account);
	}

	@Override
	public void deleteAccount(int id) {
		Account accountToDelete=getById(id);
		getSession().delete(accountToDelete);
	}

}
