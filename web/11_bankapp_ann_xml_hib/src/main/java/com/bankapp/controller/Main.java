package com.bankapp.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.model.dao.Account;
import com.bankapp.model.service.AccountService;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("bank.xml");
		AccountService accountService=ctx.getBean("accountService", AccountService.class);
		
		List<Account> accounts = accountService.getAll();
		accounts.forEach(account-> System.out.println(account));
		
		
		accountService.transfer(1, 2, 10);
		
		accounts = accountService.getAll();
		accounts.forEach(account-> System.out.println(account));
		ctx.close();
	}
}
