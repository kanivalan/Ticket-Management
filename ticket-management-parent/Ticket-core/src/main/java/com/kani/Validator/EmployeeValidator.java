package com.kani.Validator;

import com.kani.exception.ValidatorException;
import com.kani.model.Employee;
import com.kani.util.Validator;

public class EmployeeValidator {

	Validator validator = new Validator();
	
	public void saveValidator (Employee emp) throws ValidatorException {
		validator.isInvalid(emp.getName(), "Name");
		validator.isInvalid(emp.getEmailId(),"EMAIL_ID");
		validator.isInvalid(emp.getPassword(),"PASSWORD");
	}
}
