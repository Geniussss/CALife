package com.jay.ca.easylife.service;

import com.jay.ca.easylife.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	
}
