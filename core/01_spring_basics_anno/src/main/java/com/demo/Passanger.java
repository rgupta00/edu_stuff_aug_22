package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//OCP
@Component(value = "p")
public class Passanger {
	
	@Value(value = "raja")
	private String name;
	
	@Autowired
	private Vehical vehical;
	
	public Passanger() {
		System.out.println("ctr of passanger is called");
	}


	public Passanger(String name, Vehical vehical) {
		System.out.println("para... ctr of passanger is called");
		this.name = name;
		this.vehical = vehical;
	}


	public void setName(String name) {
		//System.out.println("set  name is called");
		this.name = name;
	}
	public void setVehical(Vehical vehical) {
		//System.out.println("set  vehical is called");
		this.vehical = vehical;
	}

	public void travel() {
		System.out.println("name of passanger :" + name);
		vehical.move();
	}
}
