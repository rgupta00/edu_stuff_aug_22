package com.bankapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NeedOfLogging {

	private static Logger logger= LoggerFactory.getLogger(NeedOfLogging.class);
	
	public static void main(String[] args) {
		System.out.println("code is working till line no 6");
		
		logger.info("this code is working till line 13");
		try {
		Integer val=Integer.parseInt("121A");
		}catch (Exception e) {
			logger.error("exception "+ e.toString());
		}
		
	}
}
