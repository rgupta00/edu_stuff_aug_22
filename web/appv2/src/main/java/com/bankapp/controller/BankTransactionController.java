package com.bankapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankTransactionController {

	@GetMapping(path = "showallaccounts")
	public ModelAndView hello(ModelAndView mv) {
		
		mv.setViewName("allaccounts");//i am setting logical view name
		mv.addObject("data", "you all are good students");//it goes req scope
		//RequestDispacher vs redirect
		return mv;
	}
}
