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
      <link rel="stylesheet" href="css/bootstrap.min.css">

  
</head>

<body>
  <br><br><br><br><br>
  <div class="login-box">
    <div class="lb-header">
      <a href="#" class="active" id="login-box-link">Login</a>
    </div>
    
    
    <form class="create-ticket">
    <h4 style>User Login </h4>
      <div class="u-form-group">
        <input type="email"  name="EmailId" placeholder="Email Id"/>
      </div>
      <div class="u-form-group">
        <input type="password" name ="EmailId" placeholder="Password"/>
      </div>
      <div class="u-form-group">
        <input type="text"  name="Subject" placeholder="Subject"/>
      </div>
        <div class="u-form-group">
        <input type="text"  name="Description" placeholder="Description"/>
      </div>
      <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Tutorials
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">Normal</a></li>
      <li class="disabled"><a href="#">Disabled</a></li>
      <li class="active"><a href="#">Active</a></li>
      <li><a href="#">Normal</a></li>
    </ul>
  </div>
      <div class="u-form-group">
        <button>Log in</button>
      </div>
    </form>
  </div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index.js"index.js"></script>

</body>
</html>
