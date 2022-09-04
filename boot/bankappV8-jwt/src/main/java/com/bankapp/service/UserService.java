package com.bankapp.service;

import com.bankapp.entities.UserEntity;

public interface UserService {
	public void addUser(UserEntity user);
	public UserEntity findByUsername(String username);
}
