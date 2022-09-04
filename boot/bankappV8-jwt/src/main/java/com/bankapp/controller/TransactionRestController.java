package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping(path = "transactionapi")
@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_CLERK')")
public class TransactionRestController {

	@Autowired
	private Environment environment;
	
	private AccountService accountService;

	@Autowired
	public TransactionRestController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//@RequestBody: it convert the json to java object
	//transfer
	@PostMapping(path = "transfer")
	public ResponseEntity<String> transfer(@RequestBody  TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccountId(), transferDto.getToAccountId(),
				transferDto.getAmount());
		
		String transferMessage=environment.getProperty("UserInterface.TRANSFER_SUCCESS");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(transferMessage);
	}
	
	//deposit
	@PostMapping(path = "deposit")
	public ResponseEntity<String> deposit(@RequestBody  DepositDto depositDto) {
		accountService.deposit(depositDto.getAccountId(), depositDto.getAmount());
		
		String depositMessage=environment.getProperty("UserInterface.DEPOSIT_SUCCESS");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(depositMessage);
	}
	
	//withdraw
	@PostMapping(path = "withdraw")
	public ResponseEntity<String> withdraw(@RequestBody  WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccountId(), withdrawDto.getAmount());
		
		String withdrawMessage=environment.getProperty("UserInterface.WITHDRAW_SUCCESS");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(withdrawMessage);
	}
	
}
