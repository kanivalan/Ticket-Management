package com.kani.dao;

import java.util.List;

import com.kani.model.User;

public class UserDAOTest {

	public static void main (String args[]) {
		User user = new User();
		UserDAO userDAO = new UserDAO();
		
		user.setId(1);
		user.setName("");
		user.setEmailId("kani.valan.p@gmail.com");
		user.setPassword("kani123");
		
		userDAO.save(user);
		
//		List<User> list = userDAO.findAll();
//		for (User i : list) {
//			System.out.println(i.getId()+"\t"+i.getName()+"\t"+i.getEmailId()+"\t"+i.getPassword()+"\t"+i.isActive());
//		}
		
		
	}
}
