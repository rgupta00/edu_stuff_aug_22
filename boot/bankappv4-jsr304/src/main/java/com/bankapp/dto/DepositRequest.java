package com.bankapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositRequest {
	private Integer accId;
	private Double amount;
}
