package com.bankapp.api;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.AccountDto;
import com.bankapp.entity.Account;
import com.bankapp.service.AccountService;
import com.bankapp.util.Converter;

@RestController// @Controller+ @ResponseBody   @ResponseBody it force parser to convert java object to json
@RequestMapping(path = "api")
public class BankCrudOperationApi {
	
	private AccountService accountService;
	
	@Autowired
	public BankCrudOperationApi(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("accounts/{id}")
	public AccountDto getAccount(@PathVariable(name = "id") int id) {
		return Converter.accountToAccountDto(accountService.getById(id));
	}
	
//	@GetMapping("accounts")
//	public ResponseEntity<List<Account>> getAllAccount() {
//		return ResponseEntity.status(HttpStatus.OK).body(accountService.getAll());
//	}
	
	@GetMapping("accounts")
	public List<AccountDto> getAllAccount() {
		return accountService.getAll().stream().map(Converter::accountToAccountDto).collect(Collectors.toList());
	}


	//--------create---------
	@PostMapping("accounts")
	public ResponseEntity<AccountDto> createAccount(@RequestBody @Valid  AccountDto accountDto) {
		//you need to convert accountDto to account object
		Account account=Converter.accountDtoToAccount(accountDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(Converter.accountToAccountDto(accountService.createAccount(account)));
	}
	
	//201
	//ResponseEntity<T>: bag hold 2 things : data + status code
	
	
	//--------update---------
	@PutMapping("accounts/{id}")
	public ResponseEntity<AccountDto> updateAccount(@RequestBody  AccountDto accountDto, @PathVariable(name = "id") int id) {
		Account account=Converter.accountDtoToAccount(accountDto);
		Account accountToUpdate=accountService.getById(id);
	
		accountToUpdate.setEmail(account.getEmail());
		accountToUpdate.setPhone(account.getPhone());
		return ResponseEntity.status(HttpStatus.CREATED).body(Converter.accountToAccountDto(accountService.updateAccount(accountToUpdate)));
	}
	//204
	//--------delete---------
	@DeleteMapping("accounts/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable(name = "id") int id) {
		 accountService.deleteAccount(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}















//http://localhost:8080/hello2?name=raj&address=delhi
//	@GetMapping("hello2")
//	public String helloRequestParam(@RequestParam(name = "name") String name,
//			@RequestParam(name = "address", required = false, defaultValue = "India") String address ) {
//		return "hello champs using requestParam" + name+" : "+ address;
//	}

	// http://localhost:8080/hello/{uname}/{}
//	@GetMapping("hello/{uname}")
//	public String hello(@PathVariable(name = "uname") String name) {
//		return "hello champs " + name;
//	}
	
//	@GetMapping("hello/{uname}/{add}")
//	public String hello(@PathVariable String uname, @PathVariable String add) {
//		return "hello champs " + uname+" "+ add;
//	}