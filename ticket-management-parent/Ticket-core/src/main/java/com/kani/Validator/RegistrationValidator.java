package com.kani.Validator;

import com.kani.exception.ValidatorException;
import com.kani.util.Validator;

public class RegistrationValidator {

	Validator validator = new Validator();
	
	public void registerValidator (String name,String emailId,String password) throws ValidatorException {
		
		validator.isInvalid(name, "Name");
		validator.isInvalid(emailId,"EMAIL_ID");
		validator.isInvalid(password,"PASSWORD");
	}

}
