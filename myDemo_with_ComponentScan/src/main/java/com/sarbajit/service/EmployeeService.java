package com.sarbajit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarbajit.model.EmployeeDTO;
import com.sarbajit.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	
	public EmployeeRepo employeeRepo;
	
//	@Autowired
//	public EmployeeService(EmployeeRepo employeeRepo) {
//		this.employeeRepo=employeeRepo;
//		System.out.println("Service Constructor called");
//	}
	
	public EmployeeService() {
		System.out.println("Service Constructor called");
	}
	
	public int insert(EmployeeDTO emp) {
		return employeeRepo.insert(emp);
	}
	public int remove(EmployeeDTO emp) {
		return employeeRepo.remove(emp);
	}
	public String getEmployeeList() {
		return employeeRepo.toString();
	}
	
}
