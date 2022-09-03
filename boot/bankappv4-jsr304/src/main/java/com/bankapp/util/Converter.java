package com.bankapp.util;

import com.bankapp.dto.AccountDto;
import com.bankapp.entity.Account;

public class Converter {

	////you need to convert accountDto to account object
	public static Account accountDtoToAccount(AccountDto accountDto) {
		Account account=new Account();
		account.setId(accountDto.getId());
		account.setBalance(accountDto.getBalance());
		account.setEmail(accountDto.getEmail());
		account.setName(accountDto.getName());
		account.setPhone(accountDto.getPhone());
		
		return account;
	}
	
	
	//you need to convert account to accountDto object
	public static AccountDto accountToAccountDto(Account account) {
		AccountDto accountDto=new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setBalance(account.getBalance());
		accountDto.setEmail(account.getEmail());
		accountDto.setPhone(account.getPhone());
		accountDto.setName(account.getName());
		
		
		
		return accountDto;
	}
}
