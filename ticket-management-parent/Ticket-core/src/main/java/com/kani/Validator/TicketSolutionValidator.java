package com.kani.Validator;

import com.kani.exception.ValidatorException;
import com.kani.util.Validator;

public class TicketSolutionValidator {

	Validator validator = new Validator();
	public void ticketValidator (String emailId, String password, int issueId, String ticketSolution) throws ValidatorException {
		validator.isInvalid(emailId, "email");
		validator.isInvalid(password, "password");
		validator.isInvalid(issueId, "issue id");
		validator.isInvalid(ticketSolution, "solution");
		
	}
}
