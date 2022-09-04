package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.dto.JwtRequest;
import com.bankapp.dto.JwtResponse;
import com.bankapp.entities.UserEntity;
import com.bankapp.service.UserService;

@Service
public class DetailService implements UserDetailsService {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
		String userName = jwtRequest.getUserName();
		String userPassword = jwtRequest.getUserPassword();
		authenticate(userName, userPassword);

		UserDetails userDetails = loadUserByUsername(userName);
		System.out.println(userDetails);
		String newGeneratedToken = jwtUtil.generateToken(userDetails);

		UserEntity userEntity=userService.findByUsername(userName);
		return new JwtResponse(userEntity, newGeneratedToken);
	}

	private void authenticate(String userName, String userPassword) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity userEntity = userService.findByUsername(username);
		
		System.out.println("-----------------------------");
		System.out.println(userEntity);
		if (userEntity == null) {
			throw new UsernameNotFoundException("user is not found");
		}

		SecUser secUser = new SecUser(userEntity);

		return secUser;
	}

}
