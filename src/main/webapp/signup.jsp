<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Sign Up</title>
  </head>
  <body>
    <form action = "signUpServlet" method = "POST">
    	<div class="form-group">
		    <label for="Email address">Email address</label>
		    <input type="email" class="form-control" id="Email address" aria-describedby="emailHelp" placeholder="Enter email" name="Email address" value="">
		    <small id="emailHelp" class="form-text text-muted">We'll probably never share your email with anyone else.</small>
		</div>
  		<div class="form-group">
    		<label for="Username">Username</label>
    		<input type="text" class="form-control" id="Username" placeholder="Enter Username" name="Username" value="">
  		</div>
 		 <div class="form-group">
    		<label for="Password">Password</label>
    		<input type="password" class="form-control" id="Password" placeholder="Password" name="Password" value="">
  		</div>
  		<div class="form-group">
    		<label for="Confirm Password">Confirm Password</label>
    		<input type="password" class="form-control" id="Confirm Password" placeholder="Confirm Password" name="Confirm Password" value="">
  		</div>
  		<c:if test="${! empty errorMessage}">
  			<div class="alert alert-warning" role="alert">
		  		${errorMessage}
			</div>
		</c:if>
  		<button type="submit" class="btn btn-primary" value="Call Servlet">Sign Up</button>
	</form>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>