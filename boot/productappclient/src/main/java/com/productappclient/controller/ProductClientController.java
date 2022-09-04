package com.productappclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "clientapi")
public class ProductClientController {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping(path = "products")
	public List<?>findAll(){
		return restTemplate.getForObject("http://localhost:8090/productapp/api/products", List.class);
	}
	
}
