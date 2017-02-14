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
    <link href="css/material-dashboard.css" rel="stylesheet"/>
    
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
    
</head>

<body>
<nav class="navbar navbar navbar-fixed-top">
<div class="container-fluid">
<header><div class="navbar-header">								
 <div class="navbar-left">
    <img src="img/logo.svg" alt="" width="130" height="80" class="img-responsive"/>
    </div>
</nav>
	    <div class="main-panel">
	        <div class="content">
	            <div class="container-fluid">
                <div class="row">
                 <div class="col-md-6">
 <img src="img/viewtickets.png" alt="" width="600	" height="350" class="img-responsive"/>
 </div>
						<div class="col-md-4">           
    						<div class="card card-profile">
    							<div class="card-avatar">
    								<a href="#pablo">
    									<img class="img" src="img/user_icon.svg"  />
    								</a>
    							</div>

    							<div class="content">
    								<h5 class="card-title">View User Tickets</h5>
    								 <form action='/tickets/find_user_details' method="get">
	                                    
	                                        <div class="col-md-11">
												<div class="form-group label-floating">
													<label class="control-label"style="
    height: 100%;
    left: 10px">Email address</label>
													<input type="text" name="EmailId" class="form-control" >
												</div>
	                                        </div>
	                                        <div class="col-md-11">
												<div class="form-group label-floating">
													<label class="control-label"style="
    height: 100%;
    left: 10px">Password</label>
													<input type="password" name="Password" class="form-control" >
												</div>
	                                        </div>
	                                    </div>	                                   	                                    
	                                    <div class="clearfix"></div>
	                                
                                    <a href = "userregister.jsp"  style="margin-left: 120px; color:grey;">Create an account</a><br>
    								<button type ="submit" class ="btn btn-danger btn-round">login</button>
    							</div>
    						</div>
		    			</div>
	                </div>
	            
	    
	</div>
     <footer class="footer">
	            <div class="container-fluid">
	                
	                <p style="margin-left: 380px;">
	               <script>document.write(new Date().getFullYear())</script> Ticket Management</p>	                
	            </div>
	        </footer>
	    </div>
	</div></form>

</body>

	<!--   Core JS Files   -->
	<script src="js/jquery-3.1.0.min.js" type="text/javascript"></script>
	<script src="js/material-dashboard.js" type="text/javascript"></script>
	<!-- Material Dashboard javascript methods -->
	<script src="js/material.min.js"></script>


</html>