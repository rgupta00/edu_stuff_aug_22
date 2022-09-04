package com.productappclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.productappclient.dto.Product;
import com.productappclient.proxy.ProductServiceProxy;

@RestController
@RequestMapping(path = "clientapi")
public class ProductClientController {


	@Autowired
	private ProductServiceProxy productServiceProxy;
	
	@GetMapping(path = "products")
	public List<Product>findAll(){
		return productServiceProxy.findAll();
	}
	
	@GetMapping(path = "products/{id}")
	public Product findById(@PathVariable(name = "id") int id){
		return productServiceProxy.findById(id);
	}
	
}
