<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Login, Register form</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>
  <br><br><br><br><br>
  <div class="login-box">
    <div class="lb-header">
      <a href="#" class="active" id="login-box-link">Login</a>
      <a href="#" id="signup-box-link">Sign Up</a>
    </div>
    
    
    <form class="email-login">
    <h4 style>User Login </h4>
      <div class="u-form-group">
        <input type="email"  name="EmailId" placeholder="Email Id"/>
      </div>
      <div class="u-form-group">
        <input type="password" name ="EmailId" placeholder="Password"/>
      </div>
      <div class="u-form-group">
        <button>Log in</button>
      </div>
      <div class="u-form-group">
        <a href="#" class="forgot-password">Forgot password?</a>
      </div>
    </form>
    <form class="email-signup" action='/tickets/register' method="get" >
    
      <div class="u-form-group">
      <h4> User Register</h4>
        <input type="text" name="Name" placeholder="Username"/>
      </div>
       <div class="u-form-group">
        <input type="email" name="EmailId" placeholder="Email Id"/>
      </div>
      <div class="u-form-group">
        <input type="password" name="Password" placeholder="Password"/>
      </div>
     
      <div class="u-form-group">
        <button type="submit">Sign Up</button>
      </div>
    </form>
  </div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index.js"index.js"></script>

</body>
</html>
