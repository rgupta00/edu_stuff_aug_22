package com.bankapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.AccountDetailDto;
import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

//bankapp/account/accounts
@RestController
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping(path = "accountapi")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	// ------------get--------------------
	
	//ResponseEntity<T>= data + status code
	
	@GetMapping(path = "accounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		return ResponseEntity.ok(accountService.getAll());
	}

	@GetMapping(path = "accounts/{id}")
	public ResponseEntity<Account> getOnAccounts(@PathVariable int id) {
		Account account= accountService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(account);
	}

	// @ResponseBody: convert Object -> json
	// @RequestBody: json (postman)--> java object
	// ------------post--------------------
	@PostMapping(path = "accounts")
	public ResponseEntity<Account> addAccount(@Valid  @RequestBody AccountDto accountDto) {
		//first convert accountDto==> account object
		
		Account account = accountDtoToAccount(accountDto);
		
		Account accountAdded= accountService.addAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(accountAdded);
	}
	// ------------delete--------------------

	@DeleteMapping(path = "accounts/{id}")
	public ResponseEntity<Void> deleteAnAccount(@PathVariable int id) {
		accountService.deleteAccount(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	// ------------update--------------------
	@PutMapping(path = "accounts/{id}")
	public ResponseEntity<Account> updateAccount(@RequestBody AccountDetailDto accountDetailDto,
			@PathVariable(name = "id") int id) {
		Account updatedAccount= accountService.updateAccount(id, accountDetailDto);
		return ResponseEntity.status(HttpStatus.OK).body(updatedAccount);
	}



	private Account accountDtoToAccount(AccountDto accountDto) {
		Account account=new Account();
		account.setName(accountDto.getName());
		account.setBalance(accountDto.getBalance());
		account.setEmail(accountDto.getEmail());
		account.setPhone(accountDto.getPhone());
		return account;
	}
}
