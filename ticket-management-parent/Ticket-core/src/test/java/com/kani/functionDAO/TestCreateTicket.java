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
		
/* CREATE TICKET */
		
//   createDAO.createTicket("karthi@gmail.com","prem123","FINANCE", "display fault", "display not working", "high");
		
/* UPDATE TICKET IF USER NOT STATISFIED FOR EMPLOYEE SOLUTION */
		
//       createDAO.updateTicket("kani.valan.p@gmail.com","kani123", 5, "still not working");
		
/* UPDATE TICKET STATUS TO CLOSE IF THE USER STAISFIED FOR EMLOYEE SOLUTION  */
		
//	     createDAO.updateClose("kani.valan.p@gmail.com","kani123", 5);
		
/* ASSIGN EMPLOYEE TO THE USER TICKET */
		
//		createDAO.assignTicketToEmployee("arun376@gmail.com","arun123",7,1);
		
/* EMPLOYEE GIVE A SOLUTION TO THE ISSUE ID */
		
//	    createDAO.ticketSolution("arun376@gmail.com","arun123",7,"solution given to the isuue success");
		
/* ADMIN ONLY DELETE USER TICKETS */		
		
//		createDAO.deleteTicket("arun376@gmail.com","arun123",6);
		
/* USER CAN VIEW ALL CREATED TICKETS */		
		
//	     createDAO.viewUserDetails("karthi@gmail.com","karthi123");
//	     assignvalidator.assignTicketToEmployee("arun376@gmail.com", "arun123",8,1);
//	     ticketvalidator.ticketValidator("arun376@gmail.com", "arun123",1, "solution");
//	     deletevalidator.deleteTicketValidator("arun376@gmail.com", "arun123",1);
//		 empticket.viewTicketValidator("arun376@gmail.com", "arun123");
//		createDAO.findEmployeeTickets("parithi.fire@gmail.com","parithi123" );
		
		 
	}
}


