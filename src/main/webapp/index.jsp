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
				<li><a href="${pageContext.servletContext.contextPath}/feed.jsp">Feed</a></li>
				
				
			</ul>
			</div>
			<c:if test="${empty sharedUser}">
			<div id="welcome">
				
				<div id="welcomememe">
					<img src="http://assets.nydailynews.com/polopoly_fs/1.1455925.1379167741!/img/httpImage/image.jpg_gen/derivatives/article_750/shamwow15n-1-web.jpg" alt="SHAMWOW!" style="width:300px;height:300px;">
				</div>
			</div>
			</c:if>
			<c:if test="${! empty sharedUser}">
				<c:forEach items="${eventList}" var = "event">
				    <div class="row">
					  <div class="col-4">
					    <div class="list-group" id="list-tab" role="tablist">
					      <a class="list-group-item list-group-item-action active" id="list-${event.name}-list" data-toggle="list" href="#list-${event.name})" role="tab" aria-controls="home">${event.name}</a>
					    </div>
					  </div>
					  <div class="col-8">
					    <div class="tab-content" id="nav-tabContent">
					      <div class="tab-pane fade show active" id="list-${event.name}" role="tabpanel" aria-labelledby="list-${event.name}-list">${event.date} from ${event.startTime} to ${event.endTime} at ${event.location}<br/> 
					      	${event.details}</div>
					      </div>
					  </div>
					</div>
				</c:forEach>
			</c:if>
		</div>
</body>
</html>