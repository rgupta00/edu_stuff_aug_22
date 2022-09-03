package com.bankapp.api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DepositRequest;
import com.bankapp.dto.TransferRequest;
import com.bankapp.dto.WithdrawRequest;
import com.bankapp.entity.Account;
import com.bankapp.service.AccountService;

@RestController// @Controller+ @ResponseBody   @ResponseBody it force parser to convert java object to json
@RequestMapping(path = "api")
public class BankTransactionApi {
	
	private AccountService accountService;
	
	@Autowired
	public BankTransactionApi(AccountService accountService) {
		this.accountService = accountService;
	}

	//--------transfer---------
	@PostMapping("transfer")
	public String transfer( @RequestBody  TransferRequest transferRequest) {
		accountService.transfer(transferRequest.getFromId(), transferRequest.getToId(), transferRequest.getAmount());
		return "fund is transfer successfully";
	}
	
	//--------deposit---------
	@PostMapping("deposit")
	public String deposit( @RequestBody  DepositRequest depositRequest) {
		accountService.deposit(depositRequest.getAccId(), depositRequest.getAmount());
		return "fund is deposit successfully";
	}
	
	//--------withdraw---------
	@PostMapping("withdraw")
	public String withdraw( @RequestBody  WithdrawRequest withdrawRequest) {
		accountService.withdraw(withdrawRequest.getAccId(), withdrawRequest.getAmount());
		return "fund is withdraw successfully";
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