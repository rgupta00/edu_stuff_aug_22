package com.bankapp.model.dto;

public class TransferDto {
	private Integer fromId;
	private Integer toId;
	private Double amount;
	
	public Integer getFromId() {
		return fromId;
	}
	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}
	public Integer getToId() {
		return toId;
	}
	public void setToId(Integer toId) {
		this.toId = toId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
