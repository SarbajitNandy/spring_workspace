package com.infytel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infytel.repository.CustomerRepository;

@SpringBootApplication
public class Client implements CommandLineRunner {

	@Autowired
	ApplicationContext context;
	
	@Autowired
	CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.insert();
		
		repository.addressUpdate("Toronto",7022713754L);
		System.out.println("address updated");	
	}

}
