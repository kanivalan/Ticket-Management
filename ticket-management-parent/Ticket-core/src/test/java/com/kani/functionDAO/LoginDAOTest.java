package com.kani.functionDAO;

import com.kani.exception.PersistenceException;

public class LoginDAOTest {

	public static void main(String[] args) throws PersistenceException {
		LoginDAO loginDAO = new LoginDAO();
		System.out.println(loginDAO.userLogin("kani.valan.p@gmail.com","kani123"));

	}

}
