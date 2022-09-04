package demo;

import javax.xml.ws.Endpoint;

public class Demo {

	public static void main(String[] args) {
		//publish an endpoint for soap
		
		Endpoint.publish("http://localhost:8092/calapp", new Cal());
		
		System.out.println("------------------------");
	}
}
