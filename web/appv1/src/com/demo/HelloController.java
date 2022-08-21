package com.demo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HelloController() {
    	System.out.println("ctr of servlet");
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init of servlet");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget of servlet");
	}
	

	@Override
	public void destroy() {
		System.out.println("destory of servlet object");
	}


}
