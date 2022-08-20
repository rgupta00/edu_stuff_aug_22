package com.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.factory.HibernateSessionFactory;
import java.util.*;

public class ShowAll {

	public static void main(String[] args) {

		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();

		List<AccountData> accountsAccountDatas = session
				.createQuery("select new com.crud.AccountData( a.name, a.balance) from Account a", AccountData.class)
				.getResultList();
			
		//need to just print it
		for (AccountData accountData : accountsAccountDatas) {
			System.out.println(accountData);
		}

//		List<String> accountsHolderNames=session.createQuery("select a.name from Account a",
//				String.class).getResultList();
//		//need to just print it
//		for(String accountsHolderName: accountsHolderNames) {
//			System.out.println(accountsHolderName);
//		}

//		List<Account> accounts = session.createQuery("select a from Account a", Account.class).getResultList();
//		// need to just print it
//		for (Account account : accounts) {
//			System.out.println(account);
//		}
		session.close();
		factory.close();

	}

}
