<!doctype html>
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
    <form>
    	<div class="form-group">
		    <label for="InputEmail">Email address</label>
		    <input type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp" placeholder="Enter email">
		    <small id="emailHelp" class="form-text text-muted">We'll probably never share your email with anyone else.</small>
		</div>
  		<div class="form-group">
    		<label for="InputUsername">Username</label>
    		<input type="text" class="form-control" id="InputUsername" placeholder="Enter Username">
  		</div>
 		 <div class="form-group">
    		<label for="InputPassword1">Password</label>
    		<input type="password" class="form-control" id="InputPassword1" placeholder="Password">
  		</div>
  		<div class="form-group">
    		<label for="InputPassword2">Confirm Password</label>
    		<input type="password" class="form-control" id="InputPassword2" placeholder="Confirm Password">
  		</div>
  		<div class="form-group form-check ative">
    		<input type="checkbox" class="form-check-input" id="BusinessCheck" checked="checked">
    		<label class="form-check-label active" onclick="businessHide()" for="BusinessCheck">Creating a Business Account</label>
  		</div>
  		<div id="business" class="form-group">
    		<label for="InputBusiness">Business Name</label>
    		<input type="text" class="form-control" id="InputBusiness" placeholder="Enter Business Name">
  		</div>
  		<button type="submit" class="btn btn-primary" onclick="redirect()">Sign Up</button>
	</form>
	<script>
		function businessHide() {
			var x = document.getElementById("business");
    		if (x.style.display === "none") {
        		x.style.display = "";
   	 		} else {
        		x.style.display = "none";
    		}
		}
		function redirect() {
    		window.location.href = "/businessList.jsp";
		}
	</script>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>