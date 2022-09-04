package com.bankapp.entity;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "acc_table_28_aug2")
public class Account {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private BigDecimal balance;
	
	private String phone;
	
	private String email;

	@JoinColumn(name = "acc_id_fk", nullable = false)
	@OneToMany(cascade = CascadeType.ALL)
	private List<TransactionHistory> histories=new LinkedList<>();
	
	public void addTranscation(TransactionHistory txHistory) {
		txHistory.setDateTime(LocalDateTime.now());
		histories.add(txHistory);
	}
	
	public Account(String name, BigDecimal balance, String phone, String email) {
		this.name = name;
		this.balance = balance;
		this.phone = phone;
		this.email = email;
	}
	
	
}
