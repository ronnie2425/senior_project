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
						Event is: <input type= "text" value="<%=request.getParameter("name")%>" />
			        	Starts at: <input type= "text" value="<%=request.getParameter("time") %>" />
			        	At: <input type= "text" value="<%=request.getParameter("location") %>" />
			        	Description: <input type= "text" value="<%=request.getParameter("description") %>"/>         
			        	
			        	
			        	
			        	Event is: <input type= "text" value="<%=session.getAttribute("name")%>" />
			        	Starts at: <input type= "text" value="<%=session.getAttribute("time") %>" />
			        	At: <input type= "text" value="<%=session.getAttribute("location") %>" />
			        	Description: <input type= "text" value="<%=session.getAttribute("description") %>"/>         
			  
					
						<br />	            
		
				</c>
			</div>
		
		
		</div>
	</body>
	
</html>