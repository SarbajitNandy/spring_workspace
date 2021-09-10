package com.sarbajit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sarbajit.model.EmployeeDTO;
import com.sarbajit.service.EmployeeService;

import com.sarbajit.utils.SpringConfiguration;


public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeService empService = null;
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		empService = ctx.getBean(EmployeeService.class);
		
		EmployeeDTO emp1 = new EmployeeDTO("Sarbajit","CSE");
		EmployeeDTO emp2 = new EmployeeDTO("Shalmoli","CSE");
		EmployeeDTO emp3 = new EmployeeDTO("Roshan","IT");
		
		empService.insert(emp1);
		empService.insert(emp3);
		
		empService.insert(emp2);

		empService.remove(emp1);
		empService.remove(emp2);
		empService.remove(emp3);
		
		empService.getEmployeeList();
		ctx.close();
		
	}

}
