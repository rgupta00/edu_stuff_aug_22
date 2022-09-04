package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.entity.UserEntity;
import com.bankapp.service.UserService;

@Service
public class DetailService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("-------------------------------------------------------------");
		UserEntity userEntity=userService.findByUsername(username)
				.orElseThrow(()->new UsernameNotFoundException("user is not found"));
		//u got the object which u understand ie spring sec dont understand UserEntity==> User (spring sec
		
		System.out.println(userEntity);
		return new SecUser(userEntity);
	}

}





