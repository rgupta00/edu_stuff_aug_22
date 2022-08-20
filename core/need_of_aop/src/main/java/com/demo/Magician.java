package com.demo;
// JP> PC

import org.springframework.stereotype.Component;

@Component(value ="magician")
public class Magician {
	
	public String doMagic(String hat) {
		System.out.println("abara ka dabra");
		return "rabbit form the hat";
//		if(1==1)
//			throw new PanicAttackExcpetion("call the Dr now");
	}
	
	public void doMagic1() {
		System.out.println("abara ka dabra magic 1");
		
//		if(1==1)
//			throw new PanicAttackExcpetion("call the Dr now");
	}
	
	public void eat() {
		System.out.println("eating the food");
	}
	
	public void fallIll() {
		System.out.println("get ill");
	}
}

