package com.kani.Validator;

import com.kani.exception.ValidatorException;
import com.kani.model.User;
import com.kani.util.Validator;

public class LoginValidator {

	Validator validator = new Validator();
	
	public void loginValidator(User user)throws ValidatorException{
		
		validator.isInvalid(user.getEmailId(),"EMAIL_ID");
		validator.isInvalid(user.getPassword(), "PASSWORD");	
	}
}
