<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png" />
	<link rel="icon" type="image/png" href="../assets/img/favicon.png" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Create Ticket</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
<link  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Material Dashboard CSS    -->
    <link href="css/material-dashboard.css" rel="stylesheet"/>
    
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
</head>
<body>
<%
    try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/ticket_management_system?user=root&password=kani-123");
       Statement statement = connection.createStatement() ;
       resultset =statement.executeQuery("SELECT NAME FROM DEPARTMENTS") ;
%>

<nav class="navbar navbar navbar-fixed-top">
<div class="container-fluid">
<div class="navbar-header">								
 <div class="navbar-left">
    <img src="img/logo.svg" alt="" width="130" height="80" class="img-responsive"/>
    </div>
</nav>
<div class="main-panel">
	        <div class="content">
	            <div class="container-fluid">
						<div class="col-md-10">
    <div class="card">
	                    <div class="card-header" data-background-color="red">
	                        <h4 class="title">Update Your Ticket</h4>
	                        <p class="category">If you not statisfied with our answer,update your ticket description,and we will automatically update your status to <strong>In progress</strong></p>
	                    </div>
	                    <div class="card-content">
	                        <div class="row">
    								 <form action="/tickets/update_ticket" method="GET" >
	                                    
	                                        <div class="col-md-11">
                                                                                                <i class="material-icons">person</i>
												<div class="form-group label-floating form-danger">
													<label class="control-label">Email address</label>
													<input type="email" class="form-control" name="EmailId" />
												</div>
	                                        </div>
	                                        <div class="col-md-11">
												<div class="form-group label-floating form-danger">
													<label class="control-label"style="height: 100%;left: 10px">Password</label>
													<input type="password" class="form-control" name="Password" >
												</div>
	                                        </div> 
                                            <div class="col-md-11">
												<div class="form-group label-floating form-danger">
													<label class="control-label"style="height: 100%;left: 10px">Issue Id</label>
													<input type="number" class="form-control" name="IssueId" >
												</div>
	                                        </div>                                            
                                            <div class="row">
	                                        <div class="col-md-11">
	                                            <div class="form-group">
	                                                <label>Description</label>
													<div class="form-group label-floating form-danger">
									    				<label class="control-label" style="margin-left:0px;">Update Your  new description.</label>
								    					<textarea class="form-control" rows="5" name="UpdateDescription"></textarea>
		                        					</div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    </div>	                                   	                                    
	                                    <div class="clearfix"></div>
	                                
	    <br>
	   
                     <div class="col-md-offset-5">
		<button type="submit" class="btn btn-danger">Update Ticket</button></div>
	</form>
	${ERROR}
	
	<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
</body>
<!--   Core JS Files   -->
	<script src="js/jquery-3.1.0.min.js" type="text/javascript"></script>
	<script src="js/material-dashboard.js" type="text/javascript"></script>
	<!-- Material Dashboard javascript methods -->
	<script src="js/material.min.js"></script>
</html>