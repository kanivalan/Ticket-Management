package com.kani.Validator;

import com.kani.dao.UserDAO;
import com.kani.exception.ValidatorException;
import com.kani.model.User;
import com.kani.util.Validator;

public class UserValidator {

	Validator validator = new Validator();
	
	public void saveValidator(User user)throws ValidatorException{
		validator.isInvalid(user.getName(), "name");
		UserDAO userdao=new UserDAO();
		userdao.save(user);	
	}
}
