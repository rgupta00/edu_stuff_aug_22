package com.bankapp.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "tr_history_table_28_aug2")
public class TransactionHistory {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int txId;
	private int fromAcc;
	private int toAcco;
	private BigDecimal amount;
	private TxType txType;
	private LocalDateTime dateTime;
	private String initAuthority;
	
	
	
	
}
















