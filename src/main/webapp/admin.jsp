<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

	<head>
		<title>User Info</title>
		<link href="indexstyle.css" rel="stylesheet" type="text/css" ></link>
	</head>
	
	<body>
		<div id="background">
		<div class="navbar">
			<ul>
		
				<li><a href="${pageContext.servletContext.contextPath}/indexServlet">Home</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/login.jsp">Login</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/signup.jsp">Register</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/logoutServlet">Logout</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/businessListServlet">Business List</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/editEvent.jsp">Edit Event</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/newEventServlet">New Event</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/newBusiness.jsp">New Business</a></li>
		
				<li><a href="${pageContext.servletContext.contextPath}/adminServlet">Admin</a></li>
				
				
			</ul>
			</div>
			
			<div>
				<c>
					<li>Username is: ${user.username}</li><br />
					<li>Password is: ${user.password}</li><br />
				
				<c:forEach items="${list}" var="event">
			        	Event is: ${event.name}
			        	Starts at: ${event.time}
			        	At: ${event.location}
			          
			        	<form action="${pageContext.servletContext.contextPath}/event.jsp" method="get">
							<br>Click here to view info about the event</br>
							<input name="name" type="text" value="${event.name}" hidden />
							<input name="time" type="text" value="${event.time}" hidden />
							<input name="start" type="text" value="${event.start}" hidden />
							<input name="location" type="text" value="${event.location}" hidden />
							<input name="description" type="text" value="${event.description}" hidden />
							
							
							<input name="post" type="submit" value="View"/>
						</form>
						<form action="${pageContext.servletContext.contextPath}/editEventServlet" method="post">
							<br>Click here to edit the event</br>
							<input name="eventId" type="text" value="${event.id}" hidden />
							<input name="post" type="submit" value="Edit"/>
						</form>		
						<br />	            
				</c:forEach>
				</c>
			</div>
		
		
		</div>
	</body>
	
</html>