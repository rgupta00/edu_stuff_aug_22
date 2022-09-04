package com.productappclient.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product {

	private Integer id;

	@NotNull(message = "{product.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{product.name.invalid}")
	private String name;

	@NotNull(message = "{product.price.absent}")
	@Range(min = 10, max = 100000, message = "{product.price.invalid}")
	private BigDecimal price;

	public Product(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}

}
