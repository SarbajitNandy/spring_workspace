package com.infytel;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;

@SpringBootApplication
public class Client implements CommandLineRunner {
	static Logger logger = Logger.getLogger(Client.class);
	@Autowired
	AbstractApplicationContext context;
	
	

	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CustomerService customerService = (CustomerService) context.getBean("customerService");
		logger.info("Viewing All Customer Details");
		ArrayList<CustomerDTO> cList = (ArrayList<CustomerDTO>)customerService.getAll();
		for (CustomerDTO customer : cList) {
			logger.info(customer);
		}
		
		logger.info("Display completed");
		logger.info("");
		logger.info("Let's update a Customer with new Address details");
		System.out.println("Enter the phone number of the Customer to be updated:");
		Scanner sc = new Scanner(System.in);
		Long phoneNo =  sc.nextLong();
		System.out.println("Enter the new Address:");
		String newAddress =  sc.next();
		customerService.update(phoneNo, newAddress);
		logger.info("Customer's address updated successfully!");
		sc.close();
		context.close();
	}

}
