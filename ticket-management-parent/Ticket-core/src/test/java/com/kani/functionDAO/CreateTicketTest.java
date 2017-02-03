package com.kani.functionDAO;

import java.util.Iterator;
import java.util.List;

import com.kani.dao.IssueDAO;
import com.kani.model.Issue;
import com.kani.model.User;

public class CreateTicketTest {

	public static void main(String[] args) {
		
		CreateTicket createDAO = new CreateTicket();
		

//       createDAO.createTicket("kani.valan.p@gmail.com","kani123","Hr", "error", "error in my account", "low");
		
//       createDAO.updateTicket("kani.valan.p@gmail.com","kani123", 5, "still not working");
		
//	     createDAO.updateClose("kani.valan.p@gmail.com","kani123", 5);
	
	     createDAO.viewUserDetails("kani.valan.p@gmail.com","kani123");	
		
	}
}

