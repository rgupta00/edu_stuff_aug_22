package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Foo{
	private String value;

	public Foo() {
		System.out.println("it is a default ctr");
	}

	@PostConstruct
	public void postCtrMethod() {
		System.out.println("@PostConstruct  related version");
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

	@PreDestroy
	public void preDestroyMethod() {
		System.out.println("@PreDestroy  related version");
	}
}
