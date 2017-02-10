package com.kani.Validator;

import com.kani.exception.ValidatorException;
import com.kani.util.Validator;

public class LoginValidator {

	Validator validator = new Validator();
	
	public void loginValidator(String emailId,String password)throws ValidatorException{
		
		validator.isInvalid(emailId,"EMAIL_ID");
		validator.isInvalid(password, "PASSWORD");	
	}
}
