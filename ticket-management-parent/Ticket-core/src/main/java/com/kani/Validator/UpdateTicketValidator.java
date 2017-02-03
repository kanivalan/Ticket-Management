package com.kani.Validator;

import com.kani.exception.ValidatorException;
import com.kani.util.Validator;

public class UpdateTicketValidator {

	Validator validator = new Validator();
	
	public void updateTicketValidator (String emailId,String password,int issueId,String updateDescription) throws ValidatorException {
		
		validator.isInvalid(emailId, "emailId");
		validator.isInvalid(password, "password");
		validator.isInvalid(issueId, "IssueId");
		validator.isInvalid(updateDescription, "description,");
	}
}
