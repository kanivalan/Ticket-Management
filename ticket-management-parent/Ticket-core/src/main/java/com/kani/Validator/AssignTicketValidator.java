package com.kani.Validator;

import com.kani.exception.ValidatorException;
import com.kani.util.Validator;

public class AssignTicketValidator {

	Validator validator = new Validator();
	public void assignTicketToEmployee (String emailId, String password, int issueId, int employeeId) throws ValidatorException {
		validator.isInvalid(emailId, "email");
		validator.isInvalid(password, "password");
		validator.isInvalid(issueId, "issue id");
		validator.isInvalid(employeeId, "employeeId");
		
	}
}
