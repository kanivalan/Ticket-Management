<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Login, Register form</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />


      <link rel="stylesheet" href="css/style.css">
      <link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>

  <br><br><br><br><br>
  <div class="login-box">
    <div class="lb-header">
      <a href="#" class="active" id="login-box-link">Create Ticket</a>
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
    <button class="btn btn-warning dropdown-toggle" type="button" data-toggle="dropdown">Department
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">Normal</a></li>
      <li class="disabled"><a href="#">Disabled</a></li>
      <li class="active"><a href="#">Active</a></li>
      <li><a href="#">Normal</a></li>
    </ul>
  </div><br>
  <div class="radio-inline">
  <input type="radio" <label><input type="radio" name="radio">low</label>
  </div>
  <div class="radio-inline">
  <input type="radio" <label><input type="radio" name="radio">medium</label>
  </div>
  <div class="radio-inline">
  <input type="radio" <label><input type="radio" name="radio">high</label>
  </div>
  <br><br>
       <div class="u-form-group">
        <button type="submit">create ticket</button>
      </div>
      
    </form>
  </div>
  
  
  </body>
<script src="js/bootstrap.min.js"</script>
<script type="text/javascript" src=""></script>

</html>
