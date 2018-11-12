<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Listings</title>
		<link href="listingstyle.css" rel="stylesheet" type="text/css" ></link>
	</head>
	
<body>
	<div id="background">
		<div class="navbar">
			<ul>
				<li><img src = "MSM Trading Network Logo.png" alt= "MSM logo" style="width:75px;height:75px;">
				<li><a href="${pageContext.servletContext.contextPath}/index">Home</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/login">Log in</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/register">Register</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/listings">Trade</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/logout">Logout</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/userInfo">User Info</a></li>
			</ul>
		</div>
		<div style="text-align:center;">
			<form action="${pageContext.servletContext.contextPath}/post" method="get">
			<br>Click here to create a new post</br>
			<input name="post" type="submit" value="Create"/>
			</form>
			
			Please select a platform, game, and trade method:
			<form action="feedServlet" method="post">
				
				<select name="business">
				  <option value="null">Platform</option>
				  <option value="PC">PC</option>
				  <option value="PS3">PS3</option>
				  <option value="PS4">PS4</option>
				  <option value="Xbox 360">Xbox 360</option>
				  <option value="Xbox one">Xbox One</option>
				</select>
				
				
				
				<input name ="submit" type ="submit" value="Search"/>
			</form>	
			
			<br />
			<br />
			<c:forEach items="${list}" var="event">
			        	Event is: ${event.name}
			        	Starts at: ${event.time}
			        	On: ${event.start_date}
			        	At: ${event.location}
			        	Description: ${event.description}
			        	
						<br />           
			</c:forEach>
		</div>
		</div>
		
	</body>
</html>