package com.parimal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parimal.model.User;
import com.parimal.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController
{
	@Autowired
	private UserService uService;

	@GetMapping("/alluser")
	public List<User> getAllUser()
	{
		return this.uService.getAllUser();
	}

	@GetMapping("/{uname}")
	public User getUser(@PathVariable("uname") String username)
	{
		return this.uService.getUser(username);
	}

	@PostMapping("/adduser")
	public User addUser(@RequestBody User user)
	{
		return uService.addUser(user);
	}

}
