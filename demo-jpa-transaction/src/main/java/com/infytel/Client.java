package com.infytel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;
import com.infytel.dto.CustomerDTO;
import com.infytel.dto.PlanDTO;
import com.infytel.service.CustomerService;
@SpringBootApplication
public class Client implements CommandLineRunner {
	@Autowired
	AbstractApplicationContext context;
	static Logger logger = Logger.getLogger(Client.class.getName());
	
	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		CustomerService customerService = (CustomerService)context.getBean("customerService");
		
		PlanDTO plan1 = new PlanDTO(1,"INFY_60",60,60);
		CustomerDTO customer1= new CustomerDTO(8009009010L, "Mary", 27, 'F', "Colorado","INFY", plan1);
		
		customerService.insert(customer1);
		System.out.println("Records are successfully added..");
		
		
		
		Long phoneNo=8009009009L;
		String newCurrentPlan= "INFY000000";
		PlanDTO plan2=new PlanDTO(1,"INFY_100",100,120);
		CustomerDTO customer2= new CustomerDTO();
		customer2.setPhoneNumber(phoneNo);
		customer2.setAddress("Colorado");
		customer2.setAge(27);
		customer2.setGender('F');
		customer2.setName("Mary");
		customer2.setCurrentPlan(newCurrentPlan);
		customer2.setPlan(plan2);
		
		try {
			// Method to update customer plane name and Plan table
			customerService.updateCustomer(customer2);
			System.out.println("Success : Both Customer and Plan details updated successfully!");
		} catch (DataAccessException exp) {
			
			System.out.println("ERROR : "+exp.getMessage());
			logger.error(exp.getMessage(),exp);
		}
		finally
		{
			context.close();
		}
		
		
		//comment this line in application.properties file to observe the difference
		//spring.jpa.generate-ddl=true 
		
	}
}