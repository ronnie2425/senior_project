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
				<li><a href="${pageContext.servletContext.contextPath}/login">Log in</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/register">Register</a></li>
			
				<li><a href="${pageContext.servletContext.contextPath}/logout">Logout</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/userInfo">User Info</a></li>
				
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