<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png" />
	<link rel="icon" type="image/png" href="../assets/img/favicon.png" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />


	<title>Ticket Management</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
<link  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Material Dashboard CSS    -->
<link href=${pageContext.request.contextPath}/css/material-dashboard.css  rel="stylesheet" type="text/css" />
<link href=${pageContext.request.contextPath}/css/loader.css  rel="stylesheet" type="text/css" />

    
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
    
</head>

<body>

<div class="preloader">
  <i>.</i>
  <i>.</i>
  <i>.</i>
</div>
<nav class="navbar navbar navbar-fixed-top">
<div class="container-fluid">
<header><div class="navbar-header">								
 <div class="navbar-left">
    <img src="${pageContext.request.contextPath}/img/logo.svg" alt="" width="130" height="80" class="img-responsive"/>
    </div>
</nav>
	    <div class="main-panel">
	        <div class="content">
	            <div class="container-fluid">
    								 <form action='/tickets/find_employee_tickets' method="get">	                    
	        	          
	${ERROR}
<div class="content">
	            <div class="container-fluid">
	                <div class="row">
	                    <div class="col-md-8">
	                        <div class="card">
	                            <div class="card-header" data-background-color="purple">
	                                <h4 class="title">View Employee Details</h4>
	                                <p class="category">Here is a user details</p>
	                            </div>
	                            <div class="card-content table-responsive">
	                                <table class="table">
	                                    <thead class="text-primary">
	                                    	<th>Id</th>
                <th>UserId</th>
                <th>Department Id</th>
				<th>Subject</th>
				<th>Description</th>				
				<th>Date Resolved</th>			
				

	                                    </thead>
	                        <tbody>
			<c:forEach var="c" items="${list}" varStatus="i">
				<tr>
					<td>${c.id}</td>
					<td>${c.userId.id}</td>
                    <td>${c.deptId.id}</td>
					<td>${c.subject}</td>
					<td>${c.description}</td>
					<td>${c.dateResolved}</td>					
				</tr>
			</c:forEach>
		</tbody>
	                                </table>

	                            </div>
	                        </div>
	                    </div>
	</div>
     
	    </div>
	</div></form>

</body>

<link href=${pageContext.request.contextPath}/css/material-dashboard.js  rel="stylesheet" type="text/javascript" />

</html>