package com.bankapp.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class AccountDto {
	private int id;

	@NotNull(message = "{accountDto.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{accountDto.name.invalid}")
	private String name;
	
	@NotNull(message = "{accountDto.balance.absent}")
	@Range(min = 100, max = 100000, message = "{accountDto.balance.invalid}")
	private BigDecimal balance;
	
	@NotNull(message = "{accountDto.phone.absent}")
	@Pattern(regexp = "[789][0-9]{9}", message = "{accountDto.phone.invalid}")
	private String phone;
	
	@Email(message = "{accountDto.email.invalid}")
	@NotNull(message = "{accountDto.email.absent}")
	private String email;

	public AccountDto(String name, BigDecimal balance, String phone, String email) {
		this.name = name;
		this.balance = balance;
		this.phone = phone;
		this.email = email;
	}
	
	
}
