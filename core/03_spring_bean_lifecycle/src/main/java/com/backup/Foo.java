package com.backup;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

public class Foo implements BeanNameAware, InitializingBean{
	private String value;

	public Foo() {
		System.out.println("it is a default ctr");
	}

	public void myInitMethod() {
		System.out.println("myInitMethod xml related version");
	}
	
	@PostConstruct
	public void postCtrMethod() {
		System.out.println("@PostConstruct  related version");
	}
	
	
	@PreDestroy
	public void preDestroyMethod() {
		System.out.println("@PreDestroy  related version");
	}
	
	public Foo(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		System.out.println("it is setValue");
		this.value = value;
	}

	@Override
	public void setBeanName(String name) {
		//log4j?
		System.out.println("bean is initilized :"+ name);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet is called   InitializingBean");
	}

}
