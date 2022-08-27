package com.bankapp.util;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dto.AccountDto;

public class Convert {
	public static Account convertAccountDtoToAccount(AccountDto accountDto) {
		Account account=new Account();
		account.setId(accountDto.getId());
		account.setBalance(accountDto.getBalance());
		account.setName(accountDto.getName());
		return account;
	}
}
