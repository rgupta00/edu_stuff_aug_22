package com.demo;

import lombok.Data;

@Data
public class Product {
	private Integer id;
	private String name;
	private Double price;
	private Double gst;
}
