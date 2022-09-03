package com.app.config;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.dao.UserEntity;
//this class simply convert myuser to spring sec undersntable user
public class SecUser implements UserDetails {

	private UserEntity userEntity;
	

	public SecUser(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> roles= userEntity.getRoles();
		//i need to convert List<String> to array of string
		return AuthorityUtils.createAuthorityList(roles.stream().toArray(String[]::new));
	}

	@Override
	public String getPassword() {
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		return userEntity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
