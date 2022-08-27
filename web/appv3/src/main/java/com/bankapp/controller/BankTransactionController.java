package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dto.AccountDto;
import com.bankapp.model.dto.DepositDto;
import com.bankapp.model.dto.TransferDto;
import com.bankapp.model.dto.WithdrawDto;
import com.bankapp.model.service.AccountService;
import com.bankapp.util.Convert;

@Controller
public class BankTransactionController {

	private AccountService accountService;
	
	@Autowired
	public BankTransactionController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping(path = "showallaccounts")
	public ModelAndView hello(ModelAndView mv) {
		
		mv.setViewName("allaccounts");
		mv.addObject("accounts",accountService.getAll());
		return mv;
	}
	
	//transfer amount from acc A to B--> post operation
	
	@GetMapping(path = "transfer")
	public String transferGet(ModelMap modelMap) {
		modelMap.addAttribute("transferDto", new TransferDto());
		return "transfer";
	}
	//PRG :: sol of double form submisssion problem: after POST redirect to GET
	//-----you want to render the web page
	@PostMapping(path = "transfer")
	public String transferPost(TransferDto transferDto) {
		accountService.transfer(transferDto.getFromId(), transferDto.getToId(), transferDto.getAmount());
		return "redirect:showallaccounts";
	}
	
	
	
	//--------you want to process the page
	
	
	
	@GetMapping(path = "withdraw")
	public String withdrawGet(ModelMap modelMap) {
		modelMap.addAttribute("withdrawDto", new WithdrawDto());
		return "withdraw";
	}
	//PRG :: sol of double form submisssion problem: after POST redirect to GET
	//-----you want to render the web page
	@PostMapping(path = "withdraw")
	public String withdrawPost(WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccId(), withdrawDto.getAmount());
		return "redirect:showallaccounts";
	}
	
	
	
	@GetMapping(path = "deposit")
	public String depositGet(ModelMap modelMap) {
		modelMap.addAttribute("depositDto", new DepositDto());
		return "deposit";
	}
	//PRG :: sol of double form submisssion problem: after POST redirect to GET
	//-----you want to render the web page
	@PostMapping(path = "deposit")
	public String depositPost(DepositDto depositDto) {
		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());
		return "redirect:showallaccounts";
	}
	
	
	

	@GetMapping(path = "create")
	public String createGet(ModelMap modelMap) {
		modelMap.addAttribute("accountDto", new AccountDto());
		return "create";
	}
	//PRG :: sol of double form submisssion problem: after POST redirect to GET
	//-----you want to render the web page
	@PostMapping(path = "create")
	public String createPost(AccountDto accountDto) {
		//we need to convert that AccountDto to account object
		
		Account account =Convert.convertAccountDtoToAccount(accountDto);
		
		accountService.createAccount(account);
		return "redirect:showallaccounts";
	}

	
	
	
	
	
	
	
	
	
	
	
}
