package com.sarbajit.service;

import com.sarbajit.model.EmployeeDTO;
import com.sarbajit.repository.EmployeeRepo;

public class EmployeeService {
	
	public EmployeeRepo employeeRepo;
	
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo=employeeRepo;
	}
	
	public void insert(EmployeeDTO emp) {
		employeeRepo.insert(emp);
	}
	public void remove(EmployeeDTO emp) {
		employeeRepo.remove(emp);
	}
	public void getEmployeeList() {
		System.out.println(employeeRepo.toString());
	}
	
}
