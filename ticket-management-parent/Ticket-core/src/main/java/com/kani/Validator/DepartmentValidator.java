package com.kani.Validator;

import com.kani.exception.ValidatorException;
import com.kani.model.Department;
import com.kani.util.Validator;

public class DepartmentValidator {

	Validator validator = new Validator();
	
	public void saveValidator(Department dept) throws ValidatorException {
		validator.isInvalid(dept.getName(), "name");
	}
}
