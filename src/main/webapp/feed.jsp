<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Listings</title>
		<link href="listingstyle.css" rel="stylesheet" type="text/css" ></link>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		
	</head>
	
<body>
	<div id="background">
		
		<div style="text-align:center;">
			
			
			
			<form action="feedServlet" method="post">
				
				<select name="business">
				  <option value="null">User</option>
				  <option value="TESTER">Tester</option>
			
				</select>
				
				
				
				<input name ="submit" type ="submit" value="Search"/>
			</form>	
			
		
			<c:forEach items="${list}" var="event">
					
			        	Event is: ${event.name}
			        	Starts at: ${event.time}
			        	On: ${event.start}
			        	At: ${event.location}
			        	Description: ${event.description}
			        	
						         
			</c:forEach>
		</div>
		</div>
		
	</body>
</html>