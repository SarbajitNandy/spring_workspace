package com.infy;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.dto.EmployeeDTO;
import com.infy.dto.ManufacturingUnit;
import com.infy.exception.InfyEmployeeException;
import com.infy.repository.EmployeeRepository;
import com.infy.service.EmployeeServiceImpl;

@SpringBootTest
public class IManufacturerToTraineeApplicationTests {
	@Mock
	private EmployeeRepository employeeRepository;
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

	@Test
	public void addEmployeeInvalidEmailId() throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(2007);
		employeeDTO.setName("Wilson");
		employeeDTO.setEmailId("wilson@ma2il.com");
		employeeDTO.setDateOfBirth(LocalDate.of(1996, 4, 10));
		employeeDTO.setManufacturingUnit(ManufacturingUnit.U001);

		Exception exception = Assertions.assertThrows(InfyEmployeeException.class, () ->employeeServiceImpl.addEmployee(employeeDTO)) ;
		Assertions.assertEquals("Validator.INVALID_EMAIL_ID", exception.getMessage());
	}

	@Test
	public void getEmployeeInvalidEmployeeId() throws Exception {
		
		Exception exception = Assertions.assertThrows(InfyEmployeeException.class, () ->employeeServiceImpl.getEmployeeDetails(3007)) ;
		Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", exception.getMessage());
	}

	@Test
	public void updateEmployeeInvalidEmployeeId() throws Exception {
		Exception exception = Assertions.assertThrows(InfyEmployeeException.class, () ->employeeServiceImpl.updateEmployee(3000, "sarbajit@gmail.com")) ;
		Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", exception.getMessage());
	}

	@Test
	public void deleteEmployeeInvalidEmployeeId() throws Exception {
		Exception exception = Assertions.assertThrows(InfyEmployeeException.class, () ->employeeServiceImpl.deleteEmployee(3000)) ;
		Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", exception.getMessage());		
	}

}
