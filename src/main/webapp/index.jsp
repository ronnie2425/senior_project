<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<head>
		<title>Index view</title>
		<link href="indexstyle.css" rel="stylesheet" type="text/css" ></link>
	</head>

	<body>
		<div id="background">
			<div class="navbar">
			<ul>
		
				<li><a href="${pageContext.servletContext.contextPath}/index.jsp">Home</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/login.jsp">Log in</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/signup.jsp">Register</a></li>
			
				<li><a href="${pageContext.servletContext.contextPath}/logout.jsp">Logout</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/businessEventList.jsp">Business Event list</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/businessList.jsp">Business List</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/editEvent.jsp">Edit Event</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/newEvent.jsp">New Event</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/feedServlet">Feed</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/adminServlet">Admin</a></li>
				
				
			</ul>
			</div>
			<div id="welcome">
				
				<form action="feedServlet" method="get">
				
				<select name="business">
				  <option value="null">User</option>			
				</select>
				
				
				
				<input name ="submit" type ="submit" value="Search"/>
			</form>	
			
		
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
							<input name="start" type="text" value="${event.start}" hidden />
							<input name="location" type="text" value="${event.location}" hidden />
							<input name="description" type="text" value="${event.description}" hidden />
							
							
							<input name="post" type="submit" value="View"/>
						</form>
			        	
						         
			</c:forEach>
		</div>
		</div>
			</div>
		</div>
</body>
</html>