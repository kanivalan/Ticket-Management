<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png" />
	<link rel="icon" type="image/png" href="../assets/img/favicon.png" />
     <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Login</title>
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- Bootstrap core CSS     -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  
	<!-- Login css file -->
<link href="css/login.css.css" rel="stylesheet" type="text/css">

</head>

<body>
<nav class="navbar navbar navbar-fixed-top">
<div class="container-fluid">
<header><div class="navbar-header">								
 <div class="navbar-left">
    <img src="img/logo.svg" alt="" width="130" height="80" class="img-responsive"/>
   </> </div>
</nav>
 
<div class="pen-title">

</div>
<!-- Form Module-->
<div class="module form-module">
  <div class="toggle">
    
  </div>
  <div class="form">
    <h2>Login to your account</h2>
    <form action="/tickets/user_login" method="get">
      <input type="text" placeholder="Username"/>
      <input type="password" placeholder="Password"/>

     <button type="button"  onClick="location.href='register.jsp'">login</button>
    </form>
  </div>
  
  <div class="cta"><a href="">Forgot your password?</a></div>
</div>
<br><br>
<footer class="navbar-absolute">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-md-12">
                <p style="text-align: center">
                    <font color="black"><b>Ticket Management</b>&copy;<script>document.write(new Date().getFullYear())</script> </font>
                </p>

            </div>
        </div>
    </div>
</footer>
</body>
</html>
