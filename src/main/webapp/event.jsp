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

				<li><a href="${pageContext.servletContext.contextPath}/businessList.jsp">Business List</a></li>

		
				<li><a href="${pageContext.servletContext.contextPath}/adminServlet">Admin</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/login.jsp">Log in</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/signup.jsp">Register</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/logoutServlet">Logout</a></li>
				
				
			</ul>
			</div>
			
			<div>
				<c>
						Event is:<%=request.getParameter("name")%>
			        	Starts at: <%=request.getParameter("time") %>
			        	At:<%=request.getParameter("location") %>
			        	Description: <%=request.getParameter("description") %>       
			        	
			        	
   
			  
					
						<br />	            
		
				</c>
			</div>
		
		
		</div>
	</body>
	
</html>