package com.kani.Validator;

import com.kani.exception.ValidatorException;
import com.kani.util.Validator;

public class ViewEmployeeTicket {

	Validator validator = new Validator();
	public void viewTicketValidator (String emailId, String password) throws ValidatorException {
		validator.isInvalid(emailId, "email");
		validator.isInvalid(password, "password");
		
	}
}
