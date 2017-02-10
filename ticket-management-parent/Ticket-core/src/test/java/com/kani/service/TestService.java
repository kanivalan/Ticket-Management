package com.kani.service;


import com.kani.exception.ServiceException;

public class TestService {

	public static void main(String[] args) throws ServiceException {

		TicketService testservice=new TicketService();
	
//		testservice.findUserDetails("", "");
//		testservice.createTicket("", "", "", "", "", "");
//		testservice.findUserDetails("kani.valanmail.com", "kani123");
		testservice.userLogin("kani.valan.p@gmail.com", "kdugAID");
	}

}