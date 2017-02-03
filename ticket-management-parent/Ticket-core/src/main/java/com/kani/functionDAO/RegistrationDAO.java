package com.kani.functionDAO;

import com.kani.dao.UserDAO;
import com.kani.model.User;

public class RegistrationDAO {
	
  public void registration(String name,String emailId,String password) {
		
	    User user=new User();  
		UserDAO userDao=new UserDAO();
		
		user.setName(name);
		user.setEmailId(emailId);
		user.setPassword(password);
		
		userDao.save(user);
	}
}
