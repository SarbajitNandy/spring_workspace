package com.infy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.EmployeeDTO;
import com.infy.exception.InfyEmployeeException;
import com.infy.repository.EmployeeRepository;
import com.infy.validator.Validator;

@Service(value="employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Integer addEmployee(EmployeeDTO employee) throws InfyEmployeeException {
		Validator validator = new Validator();
		try {
			validator.validate(employee);
			if (employeeRepository.getEmployeeDetails(employee.getEmployeeId())==null) return employeeRepository.addEmployee(employee);
			else throw new InfyEmployeeException("Service.EMPLOYEE_ALREADY_PRESENT");
		} catch (InfyEmployeeException e) { throw e; }		
	}
	
	@Override
	public EmployeeDTO getEmployeeDetails(Integer employeeId) throws InfyEmployeeException {
		EmployeeDTO employee= employeeRepository.getEmployeeDetails(employeeId);
		if (employee==null) throw new InfyEmployeeException("Service.EMPLOYEE_NOT_FOUND");
		return employee;
	}
	
	@Override
	public void updateEmployee(Integer employeeId, String emailId) throws InfyEmployeeException {
		
		Validator validator = new Validator();
		
		try {
			EmployeeDTO employeeDto = new EmployeeDTO(); employeeDto.setEmailId(emailId);
			validator.validate(employeeDto);
			if (getEmployeeDetails(employeeId)!=null) employeeRepository.updateEmployee(employeeId, emailId);
			else throw new InfyEmployeeException("Service.EMPLOYEE_NOT_FOUND");
		} catch (InfyEmployeeException e) {
			throw e;
		}

	}
	
	@Override
	public void deleteEmployee(Integer employeeId) throws InfyEmployeeException {
		if (getEmployeeDetails(employeeId)!=null) employeeRepository.deleteEmployee(employeeId);
		else throw new InfyEmployeeException("Service.EMPLOYEE_NOT_FOUND");
	}
}
