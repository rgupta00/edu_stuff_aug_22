package com.crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.HibernateSessionFactory;

public class Insert {

	public static void main(String[] args) {

		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx=session.getTransaction();
		try {
			
			tx.begin();
			
			Account account=new Account("amit", 2000.0);
			session.save(account);
			tx.commit();
			
		}catch(HibernateException ex) {
			
			tx.rollback();
		}
		
		session.close();
		factory.close();

	}

}
