package com.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.dao.UserEntity;
import com.app.service.UserService;

@SpringBootApplication
public class SecdemoApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SecdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("data is added...");
//		userService.addUser(new UserEntity("raj", "raj123", "raj@gmail.com", Arrays.asList("ROLE_ADMIN","ROLE_MGR","ROLE_CLERK")));
//		userService.addUser(new UserEntity("ekta", "ekta123", "ekta@gmail.com", Arrays.asList("ROLE_MGR","ROLE_CLERK")));
//		userService.addUser(new UserEntity("gun", "gun123", "gun@gmail.com", Arrays.asList("ROLE_CLERK")));
	}

}
