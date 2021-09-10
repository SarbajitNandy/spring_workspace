package com.infy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.infy.dto.EmployeeDTO;
import com.infy.entity.Employee;

@Repository()
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Integer addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
	
		employee.setEmployeeId(employeeDTO.getEmployeeId());
		employee.setName(employeeDTO.getName());
		employee.setEmailId(employeeDTO.getEmailId());
		employee.setDateOfBirth(employeeDTO.getDateOfBirth());
		employee.setManufacturingUnit(employeeDTO.getManufacturingUnit());
		entityManager.persist(employee);
		return employee.getEmployeeId();
	}

	@Override
	public EmployeeDTO getEmployeeDetails(Integer employeeId) {
		Employee employee = null;
		employee = entityManager.find(Employee.class, employeeId);
		EmployeeDTO employeeDto=null;
		if (employee!=null) {
			employeeDto = new EmployeeDTO();
			employeeDto.setEmployeeId(employee.getEmployeeId());
			employeeDto.setName(employee.getName());
			employeeDto.setEmailId(employee.getEmailId());
			employeeDto.setDateOfBirth(employee.getDateOfBirth());
			employeeDto.setManufacturingUnit(employee.getManufacturingUnit());
		}
		return employeeDto;
	}

	@Override
	public void updateEmployee(Integer employeeId, String emailId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee!=null) employee.setEmailId(emailId);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee!=null) entityManager.remove(employee);
	}
	
	
}