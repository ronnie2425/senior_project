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
		
				<li><a href="${pageContext.servletContext.contextPath}/indexServlet">Home</a></li>		
				<li><a href="${pageContext.servletContext.contextPath}/businessListServlet">Business List</a></li>
			

	
				<li><a href="${pageContext.servletContext.contextPath}/adminServlet">Admin</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/login.jsp">Log in</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/signup.jsp">Register</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/logoutServlet">Logout</a></li>
	
				
				
			</ul>
			</div>
			<div id="welcome">
				
				
			
		
			<c:forEach items="${list}" var="event">
					
			        	Event is: ${event.name}
			        	Starts at: ${event.time}
			        	At: ${event.location}
			        
			        	<form action="${pageContext.servletContext.contextPath}/event.jsp" method="get">
							<br>Click here to view info about the event</br>
							<input name="name" type="text" value="${event.name}" hidden />
							<input name="time" type="text" value="${event.time}" hidden />
							<input name="location" type="text" value="${event.location}" hidden />
							<input name="description" type="text" value="${event.description}" hidden />
							<%session.setAttribute("name", "name"); %>
							<%session.setAttribute("time", "time"); %>
							<%session.setAttribute("location", "location"); %>
							<%session.setAttribute("description", "description"); %>
							
							
							<input name="post" type="submit" value="View"/>
						</form>
			        	
						         
			</c:forEach>
		</div>
		</div>
			</div>
		</div>
</body>
</html>