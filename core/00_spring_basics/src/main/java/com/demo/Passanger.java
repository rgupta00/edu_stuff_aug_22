package com.demo;

//OCP
public class Passanger {
	
	private String name;
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
