package com.parimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MTO1Application
{

	public static void main(String[] args)
	{
		SpringApplication.run(MTO1Application.class, args);
	}

}
