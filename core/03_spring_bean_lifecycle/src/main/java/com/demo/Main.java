package com.demo;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		//ClassPathXmlApplicationContext vs AnnotationConfigApplicationContext
		
		//@PreDestroy u have to register a shut down hook AbstractApplicationContext vs ApplicationContext
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");
		ctx.registerShutdownHook();
		
		Foo foo=ctx.getBean("foo", Foo.class);
		System.out.println(foo.getValue());
		
		//BeanFactoryPP? property file
		//PropertyPlaceholderConfigurer
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












