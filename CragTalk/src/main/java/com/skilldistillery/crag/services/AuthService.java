package com.skilldistillery.crag.services;

import com.skilldistillery.crag.entities.User;

public interface AuthService {
	
	public User register(User user);
	public User getUser(String username);

}
