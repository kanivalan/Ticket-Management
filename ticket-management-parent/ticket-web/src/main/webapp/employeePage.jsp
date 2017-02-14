<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link href="css/material-dashboard.css" rel="stylesheet"/>
    
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
    
</head>

<body>
<nav class="navbar navbar navbar-fixed-top">
<div class="container-fluid">
<div class="navbar-header">								
 <div class="navbar-left">
    <img src="img/logo.svg" alt="" width="130" height="80" class="img-responsive"/>
    </div>
</nav>
	           	<div class="col-md-10">
	    <div class="main-panel">
        	<div class="content">
	            <div class="container-fluid" style="
    margin-top: 50px;">
	                <div class="card">
	                    <div class="card-content">
	                        <div class="places-buttons">
	                            <div class="row">
	                                <div class="col-md-6 col-md-offset-3 text-center">
	                                    <h5>Welcome to Ticket Management System!</h5>
	                                        <p class="category">You can assign,delete and GiveSolution your tickets!</p><br>
	                                    </h5>
	                                
	                            </div>
                                
	                            <div class="row">
									<div class="col-md-8 col-md-offset-2">
										<div class="col-md-4">
		                                    <a href="assignTicket.jsp"><button class="btn btn-success btn-block">Assign Ticket</button></a>
		                                </div>
		                                <div class="col-md-4">
		                                    <button class="btn btn-google btn-block" onclick="window.location.href='deleteTicket.jsp'">Delete Ticket</button>
		                                </div>
		                                <div class="col-md-4">
		                                    <button class="btn btn-info btn-block" onclick="window.location.href='ticketSolution.jsp'">Solution</button>
		                                </div>
									</div>
	                            </div>
	                            <div class="row">
									<div class="col-md-8 col-md-offset-4">
										
		                                <div class="col-md-6">
		                                    <button class="btn btn-instagram btn-block" onclick="window.location.href='userlogin.jsp'">log out</button>
		                                </div>
		                               
									</div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div></div></div>   </div>
	</div>

	       <footer class="footer">
	            <div class="container-fluid">
	                
	                <div class="col-md-6 col-md-offset-3 text-center">
                    <p>
	               <script>document.write(new Date().getFullYear())</script>Ticket Management</p>	                
	            </div>
	        </footer>
	 

</body>

	<!--   Core JS Files   -->
	<script src="js/jquery-3.1.0.min.js" type="text/javascript"></script>
	<script src="js/material-dashboard.js" type="text/javascript"></script>
	<!-- Material Dashboard javascript methods -->
	<script src="js/material.min.js"></script>


</html>
