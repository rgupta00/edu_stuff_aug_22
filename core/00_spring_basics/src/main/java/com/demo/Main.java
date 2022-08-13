package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
	//	System.out.println("--------------");
		Passanger passanger=(Passanger) ctx.getBean("p");
		passanger.travel();
//		
//		Passanger passanger2=(Passanger) ctx.getBean("p");
//		
//		System.out.println(passanger.hashCode());
//		System.out.println(passanger2.hashCode());
		
		
	}

}

















//Passanger passanger=new Passanger();
//Vehical vehical=new Car();
//passanger.setName("raj");
//
//passanger.setVehical(vehical);
//
//

//passanger.travel();
//I want to use spring and ask hime to provide me the object of passanger
//"spring is a framework* which do DI and it act as a container to manage the life cycle of ur bean"












