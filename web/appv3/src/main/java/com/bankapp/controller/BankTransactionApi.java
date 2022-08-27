package com.bankapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.dao.Account;
import com.bankapp.model.service.AccountService;
/*
 * 
 * i need a "parser" to convert java object to json
 * 					json <--------------> java 
 * 
 * 					jakson parser 

@Controller
@ResponseBody
 */
@RestController
@RequestMapping(path = "api")
public class BankTransactionApi {

private AccountService accountService;
	
	@Autowired
	public BankTransactionApi(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping(path = "accounts")
	public List<Account> allAccounts() {
		return accountService.getAll();
	}
}
