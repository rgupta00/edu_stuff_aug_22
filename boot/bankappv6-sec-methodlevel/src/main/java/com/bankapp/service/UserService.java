package com.bankapp.service;

import java.util.Optional;

import com.bankapp.entity.UserEntity;

public interface UserService {
	public void addUser(UserEntity userEntity);
	public Optional<UserEntity> findByUsername(String username);
}
