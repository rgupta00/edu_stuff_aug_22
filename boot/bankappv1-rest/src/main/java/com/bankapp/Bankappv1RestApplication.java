package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bankapp.entity.Account;
import com.bankapp.service.AccountService;

@SpringBootApplication
public class Bankappv1RestApplication implements CommandLineRunner {

//	@Autowired
//	private DataSource dataSource;
//	
//	@Autowired
//	private EntityManagerFactory emf;
//	
//	
	
	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		ApplicationContext  ctx= SpringApplication.run(Bankappv1RestApplication.class, args);
//		
//		String []beans=ctx.getBeanDefinitionNames();
//		for(String bean: beans) {
//			System.out.println(bean);
//		}
	}

	@Override
	public void run(String... args) throws Exception {
		
		//accountService.createAccount(new Account("amit", 1000, "6699221100", "amit@gmail.com"));
		
		//accountService.createAccount(new Account("sunita", 1000, "6699001100", "sunit@gmail.com"));
		
//		if(dataSource!=null)
//			System.out.println(" dataSource is configured");
//		
//		if(emf!=null)
//			System.out.println(" emf is configured");
	}

}
