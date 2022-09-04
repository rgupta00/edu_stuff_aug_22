package com.bankapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequest {
	private Integer fromId;
	private Integer toId;
	private Double amount;
	
	
	
}
