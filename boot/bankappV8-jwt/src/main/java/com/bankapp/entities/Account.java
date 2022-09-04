package com.bankapp.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "account_table2")
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private BigDecimal balance;

	private String email;
	private String phone;
	
	public Account(String name, BigDecimal balance, String email, String phone) {
		this.name = name;
		this.balance = balance;
		this.email = email;
		this.phone = phone;
	}
	
	
}
