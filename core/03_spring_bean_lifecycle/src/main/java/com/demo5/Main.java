package com.demo5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("demo5.xml");
		
		Company company=ctx.getBean("c", Company.class);
		company.print();
		
	}
}
