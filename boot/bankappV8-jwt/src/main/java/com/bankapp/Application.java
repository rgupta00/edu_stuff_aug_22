package com.bankapp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.entities.Account;
import com.bankapp.entities.UserEntity;
import com.bankapp.service.AccountService;
import com.bankapp.service.UserService;

//CommandLineRunner
@SpringBootApplication
public class Application implements CommandLineRunner {

	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	public Application(AccountService accountService) {
		this.accountService = accountService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		accountService.addAccount(new Account("ravi", new BigDecimal(3000.00), "ravi@gmail.com", "54545454545"));
//		accountService.addAccount(new Account("avi", new BigDecimal(3000.00), "avi@gmail.com", "54945454545"));
//		userService.addUser(new UserEntity("raj", "raj123", "raj@gmail.com", Arrays.asList("ROLE_ADMIN","ROLE_CLERK")));
//		userService.addUser(new UserEntity("ekta", "ekta123", "ekta@gmail.com", Arrays.asList("ROLE_CLERK")));
//		
		System.out.println("-------------------------------");
	}

}
