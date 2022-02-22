package com.swarn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EmployeeMain {

	public static void main(String[] args)
	{
		SpringApplication.run(EmployeeMain.class,args);
	}
}
