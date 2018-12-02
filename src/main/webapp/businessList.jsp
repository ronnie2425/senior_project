<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- --> 

<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Business List</title>
  </head>
  <body>
  <div class="navbar">
			<ul>
		
				<li><a href="${pageContext.servletContext.contextPath}/indexServlet">Home</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/login.jsp">Log in</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/signup.jsp">Register</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/logoutServlet">Logout</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/businessEventList.jsp">Business Event list</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/businessList.jsp">Business List</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/editEvent.jsp">Edit Event</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/newEvent.jsp">New Event</a></li>
		
				<li><a href="${pageContext.servletContext.contextPath}/adminServlet">Admin</a></li>
				
				
			</ul>
			</div>
    <h1>Businesses</h1>
    <form action="businessListServlet" method="get">
		<div class="list-group">
			<c:forEach items="${list}" var = "business">
  				<a href="#" class="list-group-item list-group-item-action">${business.name}</a>
  						<input name="bn" type="hidden" value="${business.name}" />
  						<form action="businessListServlet" method="post">
							<br>Click here to Subscribe</br>
							
							
							<input name="post" type="submit" value="Subscribe"/>
						</form>	
			</c:forEach>
		</div>
		<button type="submit" class="btn btn-primary">See Businesses</button>
	</form>
	
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>