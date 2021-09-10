package com.infytel;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;
import com.infytel.service.CustomerServiceImpl;

public class ClientApplication {
	static Logger logger = Logger.getLogger(ClientApplication.class);

	public static void main(String[] args) {
		CustomerService customerService = new CustomerServiceImpl();
		CustomerDTO customer = new CustomerDTO(7022713722L, "Lucy", 27, 'F', "INDIA", 3);
		customerService.insert(customer);
		System.out.println("Records are successfully added..");
		System.out.println("Enter the phone Number of the Customer which has to be deleted.");
		Scanner scanner = new Scanner(System.in);
		Long phoneNo = scanner.nextLong();
		int result = customerService.remove(phoneNo);
		if (result == 1) {
			System.out.println("Success : Record deleted successfully ");
		} else {
			System.out.println("Error : No record found for the given phone number ");
		}
		scanner.close();
	}
}