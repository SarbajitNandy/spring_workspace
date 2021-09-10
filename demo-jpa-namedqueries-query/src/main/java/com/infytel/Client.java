package com.infytel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;


@SpringBootApplication
public class Client implements CommandLineRunner {

	@Autowired
	ApplicationContext context;
	
	@Autowired
	CustomerService service;

	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CustomerDTO customer1= new CustomerDTO(7022713754L, "Adam", 27, 'M', "Chicago", 1);
		CustomerDTO customer2= new CustomerDTO(7022713744L, "Susan", 27, 'F', "Alberta", 2);
		CustomerDTO customer3= new CustomerDTO(7022713745L, "Andrew", 27, 'M', "New York", 2);
		CustomerDTO customer4= new CustomerDTO(7022713746L, "Diana", 25, 'F', "Toronto", 1);
		CustomerDTO customer5= new CustomerDTO(7022713747L, "Grace", 27, 'F', "Calgary", 1);
		
		
		service.insertCustomer(customer1);
		service.insertCustomer(customer2);
		service.insertCustomer(customer3);
		service.insertCustomer(customer4);
		service.insertCustomer(customer5);
         
		Customer cus=service.getCustomer("Toronto");
		if(cus!=null)
        	System.out.println("Customer found: "+cus);
        else
        	System.out.println("not found");
	}

}
