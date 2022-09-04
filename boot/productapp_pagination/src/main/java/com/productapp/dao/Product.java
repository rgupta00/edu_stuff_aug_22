package com.productapp.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name = "p_table_pagination")
public class Product {

	private int id;
	private String name;
	private int quantity;
	private long price;
	public Product(String name, int quantity, long price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	
}
