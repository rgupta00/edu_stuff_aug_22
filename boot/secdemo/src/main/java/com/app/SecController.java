package com.app;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.config.SecUser;

@RestController
public class SecController {

	@GetMapping("home")
	public String home() {
		return "home";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("mgr")
	public String mgr() {
		return "mgr";
	}
	
	@GetMapping("clerk")
	public String clerk(@AuthenticationPrincipal SecUser secUser) {
		System.out.println("------------------------%%%%%%%%%%%-----------------------");
		System.out.println(secUser.getUsername());
		return "clerk";
	}
}
