package com.kani.functionDAO;

import com.kani.dao.EmployeeDAO;
import com.kani.dao.UserDAO;
import com.kani.exception.PersistenceException;
import com.kani.model.Employee;


public class LoginDAO {

	UserDAO userDAO = new UserDAO();
	Employee emp = new Employee();
	EmployeeDAO empDAO = new EmployeeDAO(); 
	
	public boolean userLogin(String emailId,String password)throws PersistenceException {
		System.out.println(emailId);
		userDAO.findOne(emailId,password).getId(); 
	
			return true;
	}
	public boolean employeeLogin(String emailId,String password)throws PersistenceException {
		empDAO.findEmpPassword(emailId).getPassword(); 
			return true;
	}
	
}