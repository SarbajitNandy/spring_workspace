package com.sarbajit.utils;

import org.springframework.context.annotation.Configuration;

import com.sarbajit.repository.EmployeeRepo;
import com.sarbajit.service.EmployeeService;

import org.springframework.context.annotation.Bean;


@Configuration
public class SpringConfiguration {
	
	@Bean(name="createEmployeeRepository")
	public EmployeeRepo createEmployeeRepo() {
		return new EmployeeRepo();
	}
	
	@Bean(name="createEmployeeService")
	public EmployeeService createEmployeeService() {
		return new EmployeeService(createEmployeeRepo());
	}
	
}
