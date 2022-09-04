package com.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.UserDao;
import com.bankapp.entities.UserEntity;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void addUser(UserEntity user) {
		//user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public UserEntity findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
