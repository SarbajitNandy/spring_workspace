package com.sarbajit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sarbajit.model.EmployeeDTO;
import com.sarbajit.service.EmployeeService;

import com.sarbajit.utils.SpringConfiguration;

@SpringBootApplication
public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeService empService1 = null, empService2 = null;
		
		AbstractApplicationContext ctx = (AbstractApplicationContext)SpringApplication.run(Client.class, args);
		
		empService1 = (EmployeeService) ctx.getBean("employeeService");
		empService2 = (EmployeeService) ctx.getBean("employeeService");
		
		System.out.println(empService1==empService2);
		System.out.println(empService1.equals(empService2) );
//		
//		EmployeeDTO emp1 = new EmployeeDTO("Sarbajit","CSE");
//		EmployeeDTO emp2 = new EmployeeDTO("Shalmoli","CSE");
//		EmployeeDTO emp3 = new EmployeeDTO("Roshan","IT");
//		
//		System.out.println(empService.insert(emp1));
//		System.out.println(empService.insert(emp3));;
//		
////		empService.insert(emp2);
//
//		System.out.println(empService.remove(emp1));;
////		empService.remove(emp2);
//		System.out.println(empService.remove(emp3));;
//		
//		System.out.println(empService.getEmployeeList());
		ctx.close();
		
	}

}
