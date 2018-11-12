<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Listings</title>
		<link href="listingstyle.css" rel="stylesheet" type="text/css" ></link>
	</head>
	
<body>
	<div id="background">
		
		<div style="text-align:center;">
			
			
			Please select a platform, game, and trade method:
			<form action="feedServlet" method="post">
				
				<select name="business">
				  <option value="null">User</option>
				  <option value="TESTER">Tester</option>
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
			        	On: ${event.start}
			        	At: ${event.location}
			        	Description: ${event.description}
			        	
						<br />           
			</c:forEach>
		</div>
		</div>
		
	</body>
</html>