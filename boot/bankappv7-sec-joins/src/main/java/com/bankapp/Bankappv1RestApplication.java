package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bankapp.service.AccountService;
import com.bankapp.service.UserService;

@SpringBootApplication
public class Bankappv1RestApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		ApplicationContext  ctx= SpringApplication.run(Bankappv1RestApplication.class, args);
	}

//	public void ConfigureServices(IServiceCollection services)
//	{
//	    services.AddMvc().AddJsonOptions(options => 
//	     options.SerializerSettings.ReferenceLoopHandling = ReferenceLoopHandling.Ignore);
//	}
//	
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("data is added...");
//		userService.addUser(new UserEntity("raj", "raj123", "raj@gmail.com", Arrays.asList("ROLE_ADMIN","ROLE_MGR","ROLE_CLERK")));
//		userService.addUser(new UserEntity("ekta", "ekta123", "ekta@gmail.com", Arrays.asList("ROLE_MGR","ROLE_CLERK")));
//		userService.addUser(new UserEntity("gun", "gun123", "gun@gmail.com", Arrays.asList("ROLE_CLERK")));

		//accountService.createAccount(new Account("amit", new BigDecimal(1000), "6699221100", "amit@gmail.com"));
		
		//accountService.createAccount(new Account("sunita", new BigDecimal(1000), "6699001100", "sunit@gmail.com"));
		
//		if(dataSource!=null)
//			System.out.println(" dataSource is configured");
//		
//		if(emf!=null)
//			System.out.println(" emf is configured");
	}

}
