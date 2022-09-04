package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransferDto {
	private Integer fromAccountId;
	private Integer toAccountId;
	private Double amount;
}
