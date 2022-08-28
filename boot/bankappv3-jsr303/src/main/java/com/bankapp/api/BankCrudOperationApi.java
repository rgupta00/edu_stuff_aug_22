package com.bankapp.api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.entity.Account;
import com.bankapp.service.AccountService;

@RestController// @Controller+ @ResponseBody   @ResponseBody it force parser to convert java object to json
@RequestMapping(path = "api")
public class BankCrudOperationApi {
	
	private AccountService accountService;
	
	@Autowired
	public BankCrudOperationApi(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("accounts/{id}")
	public Account getAccount(@PathVariable(name = "id") int id) {
		return accountService.getById(id);
	}
	
	@GetMapping("accounts")
	public List<Account> getAllAccount() {
		return accountService.getAll();
	}

	//--------create---------
	
	@PostMapping("accounts")
	public Account createAccount(@RequestBody  Account account) {
		return accountService.createAccount(account);
	}
	
	//--------update---------
	@PutMapping("accounts/{id}")
	public Account updateAccount(@RequestBody  Account account, @PathVariable(name = "id") int id) {
		Account accountToUpdate=accountService.getById(id);
		accountToUpdate.setEmail(account.getEmail());
		accountToUpdate.setPhone(account.getPhone());
		
		return accountService.updateAccount(accountToUpdate);
	}
	
	//--------delete---------
	@DeleteMapping("accounts/{id}")
	public void deleteAccount(@PathVariable(name = "id") int id) {
		 accountService.deleteAccount(id);
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