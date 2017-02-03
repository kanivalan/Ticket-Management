package com.kani.functionDAO;

import com.kani.dao.UserDAO;


public class LoginDAO {

	UserDAO userDAO = new UserDAO();
	public boolean login(String emailId,String password) {
		String s = userDAO.findOne(emailId).getPassword();
		if (s.equals(password)) 
			return true;
		return false;
	}

	
}