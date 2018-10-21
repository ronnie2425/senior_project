<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
		<link href="indexstyle.css" rel="stylesheet" type="text/css" ></link>
	</head>

	<body>
		<div id="background">
			<div class="navbar">
			<ul>
		
				<li><a href="${pageContext.servletContext.contextPath}/index">Home</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/login.jsp">Log in</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/signup.jsp">Register</a></li>
			
				<li><a href="${pageContext.servletContext.contextPath}/logout.jsp">Logout</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/businessEventList.jsp">Business Event list</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/businessList.jsp">Business List</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/editEvent.jsp">Edit Event</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/newEvent.jsp">New Event</a></li>
				
			</ul>
			</div>
			<div id="welcome">
				
				<div id="welcomememe">
					<img src="http://assets.nydailynews.com/polopoly_fs/1.1455925.1379167741!/img/httpImage/image.jpg_gen/derivatives/article_750/shamwow15n-1-web.jpg" alt="SHAMWOW!" style="width:300px;height:300px;">
				</div>
			</div>
		</div>
</body>
</html>