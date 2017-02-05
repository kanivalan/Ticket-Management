package com.kani.Validator;

import com.kani.exception.ValidatorException;
import com.kani.util.Validator;

public class DeleteValidator {


		Validator validator = new Validator();
		public void deleteTicketValidator (String emailId, String password, int issueId) throws ValidatorException {
			validator.isInvalid(emailId, "email");
			validator.isInvalid(password, "password");
			validator.isInvalid(issueId, "issue id");
			
		}
}

