package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity//(debug = true)
@Configuration
public class SecConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);	
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests((requests) -> requests.anyRequest().authenticated())
		super.configure(http);
//		http.csrf().disable()
//		.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated())
//		
////		.antMatchers("/api/accounts/**").hasAnyRole("ADMIN")
////		.antMatchers("/api/accounts/transactions/**").hasAnyRole("ADMIN","MGR")
//	
//	
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}




