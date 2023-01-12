package com.parimal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parimal")
public class WelcomeController
{

	// this should not be protected
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome()
	{
		String str = "Welcome to Parimal App without security";

		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
	}

	// this should be protected
	@GetMapping("/welcomeP")
	public ResponseEntity<String> welcomeP()
	{

		String str1 = "Welcome to Parimal App with security";
		return new ResponseEntity<String>(str1, HttpStatus.ACCEPTED);
	}

}
