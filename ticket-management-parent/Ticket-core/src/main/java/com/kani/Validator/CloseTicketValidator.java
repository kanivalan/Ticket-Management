package com.kani.Validator;

import com.kani.exception.ValidatorException;
import com.kani.util.Validator;

public class CloseTicketValidator {

	Validator validator = new Validator();
	
	public void closeTicketValidator (String emailId,String password,int issueId) throws ValidatorException {
		
		validator.isInvalid(emailId, "emailId");
		validator.isInvalid(password, "password");
		validator.isInvalid(issueId, "IssueId");
	}
}
