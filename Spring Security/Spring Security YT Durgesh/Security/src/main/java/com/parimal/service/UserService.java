package com.parimal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.parimal.model.User;

@Service
public class UserService
{

	List<User> list = new ArrayList<>();

	public UserService()
	{
		list.add(new User("abc", "abc", "abc@gmail.com"));
		list.add(new User("xyz", "xyz", "xyz@gmail.com"));
	}

	// Get All user
	public List<User> getAllUser()
	{
		return this.list;
	}

	// Get Single User
	public User getUser(String username)
	{
		return this.list.stream().filter(s -> s.getUsername().equals(username)).findAny().orElse(null);
	}

	// Add User
	public User addUser(User user)
	{
		this.list.add(user);

		return user;
	}

}
