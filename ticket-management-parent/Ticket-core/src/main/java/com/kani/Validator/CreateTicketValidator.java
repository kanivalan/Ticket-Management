package com.kani.Validator;

import com.kani.exception.ValidatorException;
import com.kani.util.Validator;

public class CreateTicketValidator {

	Validator validator = new Validator();
	
	public void createTicketValidator (String emailId,String password,String department,String subject,String description,String priority) throws ValidatorException {
		
		validator.isInvalid(emailId, "emailId");
		validator.isInvalid(password, "password");
		validator.isInvalid(description, "description,");
		validator.isInvalid(subject, "subject");
		validator.isInvalid(priority, "priority");
	}
public void findUserDetails(String emailId,String password) throws ValidatorException{
		
		validator.isInvalid(emailId, "EMAIL");
		validator.isInvalid(password, "PASSWORD");
		
	}
}
