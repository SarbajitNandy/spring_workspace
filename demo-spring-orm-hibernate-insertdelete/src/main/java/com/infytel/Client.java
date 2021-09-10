package com.infytel;

import java.util.Scanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;
import org.apache.log4j.Logger;
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
		CustomerService customerService = (CustomerService)context.getBean("customerService");
		
		CustomerDTO customer1= new CustomerDTO(9022713760L, "Debashis", 27, 'M', "BBSR", 1);
		CustomerDTO customer2= new CustomerDTO(9022713761L, "Robert", 27, 'M', "PUNE", 2);
		CustomerDTO customer3= new CustomerDTO(9022713762L, "Lucy", 27, 'F', "MUMBAI", 3);
		
		customerService.insert(customer1);
		customerService.insert(customer2);
		customerService.insert(customer3);
		logger.info("Records are successfully added..");
		
		System.out.println("Enter the phone Number of the Customer which has to be deleted.");
		Scanner scanner = new Scanner(System.in);
		Long phoneNo = scanner.nextLong();

		// Invoking Service layer method to remove Employee details from
		// Employee table
		int result = customerService.remove(phoneNo);
		if (result == 1) {
			logger.info("Success : Record deleted successfully ");
		} else {
			logger.info("Error : No record found for the given phone number ");
		}
		scanner.close();
		context.close();
	}

}
