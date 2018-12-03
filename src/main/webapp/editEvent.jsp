<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Edit Event</title>
  </head>
  <body>
    <form action="editEventServlet" method="post">
  		<div class="form-group">
    		<label for="InputEventName">Event Title</label>
    		<input type="text" class="form-control" placeholder="${event.name}" id="InputEventName" placeholder="Enter Name For Event">
  		</div>
  		<select class="custom-select">
  			<option>Select a business from this list</option>
  			<c:forEach items="${businessList}" var = "business">
  				<option> ${business} </option>
  			</c:forEach>
  		</select>
  		<div class="form-group">
    		<label for="InputEventDetails">Event Details</label>
    		<textarea class="form-control" id="InputEventName" placeholder="Describe the event" rows="3">${event.description}</textarea>
  		</div>
  		<div class="form-group">
		  <label for="example-date-input">Date</label>
		  <input class="form-control" type="date" value="${event.time}" id="eventDate">
		</div>
		<div class="form-group">
		  <label for="startTime">Start Time</label>
		  <input class="form-control" type="time" value="${event.start}" id="startTime">
		</div>
		<div class="form-group">
		  <label for="endTime">End Time</label>
		  <input class="form-control" type="time" value="${event.end}" id="endTime">
		</div>
		<div class="form-group">
    		<label for="InputLocation">Event Location</label>
    		<input type="text" class="form-control" value="${event.location}" id="InputLocation" placeholder="Location">
  		</div>
  		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>