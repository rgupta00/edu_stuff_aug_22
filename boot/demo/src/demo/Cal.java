package demo;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Cal {

	@WebMethod
	public int add(int a, int b) {
		return a+b;
	}
}
