package com.kani.functionDAO;

import java.util.Iterator;
import java.util.List;

import com.kani.Validator.AssignTicketValidator;
import com.kani.Validator.DeleteValidator;
import com.kani.Validator.TicketSolutionValidator;
import com.kani.Validator.ViewEmployeeTicket;
import com.kani.dao.IssueDAO;
import com.kani.exception.PersistenceException;
import com.kani.exception.ValidatorException;
import com.kani.model.Issue;
import com.kani.model.User;

public class TestCreateTicket {

	public static void main(String[] args) throws PersistenceException, ValidatorException {
		
		CreateTicket createDAO = new CreateTicket();
		AssignTicketValidator assignvalidator = new AssignTicketValidator();
		TicketSolutionValidator ticketvalidator = new TicketSolutionValidator();
		DeleteValidator deletevalidator = new DeleteValidator();
		ViewEmployeeTicket empticket = new ViewEmployeeTicket();
//       createDAO.createTicket("kani.valan.p@gmail.com","kani123","Hr", "error", "error in my account", "low");
		
//       createDAO.updateTicket("kani.valan.p@gmail.com","kani123", 5, "still not working");
		
//	     createDAO.updateClose("kani.valan.p@gmail.com","kani123", 5);
	
	     createDAO.viewUserDetails("kani.valan.p@gmail.com","kani123");
	     assignvalidator.assignTicketToEmployee("arun376@gmail.com", "arun123",1,1);
	     ticketvalidator.ticketValidator("arun376@gmail.com", "arun123",1, "solution");
	     deletevalidator.deleteTicketValidator("arun376@gmail.com", "arun123",1);
		 empticket.viewTicketValidator("arun376@gmail.com", "arun123");
	}
}


