package com.infy.validator;

import java.util.regex.Pattern;

import com.infy.dto.EmployeeDTO;
import com.infy.exception.InfyEmployeeException;

public class Validator {
	
	public static void validate(EmployeeDTO employee) throws InfyEmployeeException	{
		if (!validateEmailId(employee.getEmailId())) throw new InfyEmployeeException("Validator.INVALID_EMAIL_ID");
		
	}
	
	public static Boolean validateEmailId(String emailId)	{
		return Pattern.matches("\\w+@([A-Za-z]+).[A-Za-z]+", emailId);
	}

}
