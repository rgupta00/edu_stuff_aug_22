package com.bankapp.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//<bean id="accountDao2" class="com.bankapp.model.dao.AccountDaoImplJdbc"/>
@Repository(value = "accountDao2")
@Primary
public class AccountDaoImplJdbc implements AccountDao {
	
	private static final String SELECT_FROM_ACCOUNT_BYID = "select * from account2 where id=?";
	private static final String SELECT_FROM_ACCOUNT2 = "select * from account2";
	private static final String UPDATE_AACCOUNT_QUERY = "update account2 set balance =? where id=?";
	private static final String CREATE_AACCOUNT_QUERY = "insert into account2(name, balance) values(?,?)";
	private static final String DLETE_AACCOUNT_QUERY = "delete from account2 where id=?";
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDaoImplJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Account> getAll() {
		return jdbcTemplate.query(SELECT_FROM_ACCOUNT2, new AccountRowMapper());
	}

	@Override
	public Account getById(int id) {
		return jdbcTemplate.queryForObject(SELECT_FROM_ACCOUNT_BYID, new AccountRowMapper(), id);
	}

	@Override
	public void updateAccount(Account account) {
		jdbcTemplate.update(UPDATE_AACCOUNT_QUERY, new Object[] {account.getBalance(), account.getId()});
	}

	@Override
	public void addAccount(Account account) {
		jdbcTemplate.update(CREATE_AACCOUNT_QUERY, new Object[] {account.getName(), account.getBalance()});
	}

	@Override
	public void deleteAccount(int id) {
		jdbcTemplate.update(DLETE_AACCOUNT_QUERY, id);
	}

}
