package com.bankapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithdrawRequest {
	private Integer accId;
	private Double amount;
	
}
