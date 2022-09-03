package com.app.service;

import java.util.Optional;

import com.app.dao.UserEntity;

public interface UserService {
	public void addUser(UserEntity userEntity);
	public Optional<UserEntity> findByUsername(String username);
}
