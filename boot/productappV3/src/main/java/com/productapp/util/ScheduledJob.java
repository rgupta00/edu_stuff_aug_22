package com.productapp.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;

@Component
public class ScheduledJob {
	private Logger logger = LoggerFactory.getLogger(ScheduledJob.class);
	
	@Autowired
	private ProductService service;
	
	@Scheduled(initialDelay = 5000, fixedRate = 5000)
	public void fixedRateJob() {
	// Add scheduled logic here

		//List<Product> products = service.findAll();
		service.evictCache();
		logger.info("=========cache is cleaned =======================");
;
	}
}
