package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.entity.Account;
import com.bankapp.entity.TransactionHistory;
import com.bankapp.entity.TxType;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepository;
import com.bankapp.util.MyLogger;

//@Transactional(isolation = Isolation.READ_COMMITTED,noRollbackFor = {MyEx.class} )
@Transactional
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public List<Account> getAll() {
//		if(1==1)
//			throw new RuntimeException();// just telling u let assume thre is some ex in my code
		return accountRepository.findAll();
	}

	@Override
	public Account getById(int id) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()->new BankAccountNotFoundException("account with id " + id + " is not found") );
		return account;
	}

	@Override
	public void deleteAccount(int id) {
		Account accountToDelete= getById(id);
		accountRepository.delete(accountToDelete);
	}

	@MyLogger
	@Override
	public void transfer(int fromAccId, int toAccId, double amount) {
		Account fromAccount = getById(fromAccId);
		Account toAccount = getById(toAccId);

		fromAccount.setBalance(fromAccount.getBalance().subtract(new BigDecimal(amount)));
		toAccount.setBalance(toAccount.getBalance().add(new BigDecimal(amount)));

		
		//how to get the currently logged in user in service layer?
		TransactionHistory history=new TransactionHistory();
		history.setAmount(new BigDecimal(amount));
		history.setFromAcc(fromAccId);
		history.setToAcco(toAccId);
		history.setInitAuthority("raj");
		history.setTxType(TxType.TRANSFER);
		
		fromAccount.getHistories().add(history);
		
		accountRepository.save(fromAccount);

		accountRepository.save(toAccount);
	}

	@Override
	public void withdraw(int accId, double amount) {
		Account account = getById(accId);
		account.setBalance(account.getBalance().subtract(new BigDecimal(amount)));
		accountRepository.save(account);
	}

	@Override
	public void deposit(int accId, double amount) {
		Account account = getById(accId);
		account.setBalance(account.getBalance().add(new BigDecimal(amount)));
		accountRepository.save(account);
	}

	@Override
	public Account createAccount(Account account) {
		accountRepository.save(account);
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		accountRepository.save(account);//for both saving and update we have only save method
		return account;
	}

}
