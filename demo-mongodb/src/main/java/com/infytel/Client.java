package com.infytel;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;

@SpringBootApplication
public class Client implements CommandLineRunner{

	
	@Autowired
	CustomerService service;

	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CustomerDTO customer1=new CustomerDTO(785671000L, "Alex",27, 'M', "Alberta");
		CustomerDTO customer2=new CustomerDTO(785671001L, "Susan",27, 'F', "Chicago");

		// Invoking Service layer method to insert Customer details into
		// Customere table
		service.insertCustomer(customer1);
		service.insertCustomer(customer2);
		
		System.out.println("Added Customers successfully");

		System.out.println("Enter the Customer Phone Number to be deleted");
		Scanner scanner = new Scanner(System.in);
		Long phoneNo = scanner.nextLong();

		// Invoking Service layer method to remove Customer details from
		// Customer table
		service.removeCustomer(phoneNo);
		System.out.println("Customer removed successfully");
		scanner.close();
	}

}
