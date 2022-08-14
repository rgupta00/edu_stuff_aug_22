package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.dao.AccountDaoImplJdbc;
import com.bankapp.model.dao.AccountDaoImplMap;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.AccountServiceImpl;

@Configuration
@ComponentScan(basePackages = { "com.bankapp" })
public class AppConfig {

	@Autowired
	@Bean(name = "accountService")
	public AccountService getAccountService(AccountDao accountDao) {
		AccountService accountService = new AccountServiceImpl(accountDao);
		return accountService;
	}
	@Profile("test")
	@Bean
	public AccountDao getAccountDao() {
		AccountDao accountDao1 = new AccountDaoImplMap();
		return accountDao1;
	}
	@Profile("preprod")
	@Bean
	public AccountDao getAccountDao2() {
		AccountDao accountDao2 = new AccountDaoImplJdbc();
		return accountDao2;
	}

}
