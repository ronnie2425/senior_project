<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

	<head>
		<title>User Info</title>
		<link href="indexstyle.css" rel="stylesheet" type="text/css" ></link>
	</head>
	
	<body>
		<div id="background">
			<form action="adminServlet" method="get">
			<div>
				<c>
					<li>Username is: ${user.username}</li><br />
					<li>Password is: ${user.password}</li><br />
				
				<c:forEach items="${list}" var="event">
			        	Event is: ${event.name}
			        	Starts at: ${event.time}
			        	On: ${event.start}
			        	At: ${event.location}
			        	Description: ${event.description}         
			        	<form action="${pageContext.servletContext.contextPath}/event.jsp" method="get">
							<br>Click here to view info about the event</br>
							<input name="name" type="text" value="${event.name}" hidden />
							<input name="time" type="text" value="${event.time}" hidden />
							<input name="start" type="text" value="${post.start}" hidden />
							<input name="location" type="text" value="${post.location}" hidden />
							<input name="description" type="text" value="${post.description}" hidden />
							
							
							<input name="post" type="submit" value="View"/>
						</form>
						<form action="${pageContext.servletContext.contextPath}/editEvent" method="post">
							<br>Click here to edit the event</br>
							<input name="eventId" type="text" value="${event.id}" hidden />
							<input name="post" type="submit" value="Edit"/>
						</form>		
						<br />	            
				</c:forEach>
				</c>
			</div>
			<input name ="submit" type ="submit" value="Search"/>
			</form>
		</div>
	</body>
	
</html>