package com.kani.service;


import com.kani.exception.PersistenceException;
import com.kani.exception.ServiceException;

public class TestService {

	public static void main(String[] args) throws ServiceException, PersistenceException {

		TicketService testservice=new TicketService();
	
//		testservice.findUserDetails("", "");
		testservice.createTicket("", "", "", "", "", "");

	}

}