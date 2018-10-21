<!DOCTYPE HTML>

<html>
	<head>
		<title>Login</title>
		<link href="loginstyle.css" rel="stylesheet" type="text/css" ></link>
	</head>
	
<body>
	<div id ="background">
	<div class="navbar">
		<ul>
		
			<li><a href="${pageContext.servletContext.contextPath}/index">Home</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/login">Log in</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/register">Register</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/listings">Trade</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/logout">Logout</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/userInfo">User Info</a></li>
	

		</ul>
	</div>	
		<form action="${pageContext.servletContext.contextPath}/login" method="post">
		
		Please enter valid MSM credentials:
		<table>
			<tr>
				<td class="username">Username:</td>
				<td><input type="text" name="Username" value="" /></td>
			</tr>
			
			<tr>
				<td class="password">Password:</td>
				<td><input type="password" name="Password" value="" /></td>
			</tr>
		</table>
		
		<input name ="submit" type ="submit" value="Log in"/>
		</form>		
		
		${error}
	</div>
</body>
</html> 