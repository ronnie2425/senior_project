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

    <title>Event Details</title>
  </head>
  <body>
    <form action="newEventServlet" method="post">
  		<div class="form-group">
    		<label for="InputEventName">Event Title</label>
				<c:if test="${! empty Event name}">
  					<div class="alert alert-warning" role="alert" name="Event name">
		  				${Event name}
					</div>
				</c:if>
		</div>
  		<div class="form-group">
    		<label for="InputEventDetails">Event Details</label>
    			<c:if test="${! empty Event name}">
  					<div class="alert alert-warning" role="alert" name="Description">
		  				${Event name}
					</div>
				</c:if>
    		<textarea class="form-control" id="InputEventName" placeholder="Describe the Event" rows="3" name="Description" value=""></textarea>
  		</div>
  		<div class="form-group">
		  <label for="example-date-input">Date</label>
		  	<c:if test="${! empty Event name}">
 				<div class="alert alert-warning" role="alert" name="Description">
	  				${Event name}
				</div>
			</c:if>
		  <input class="form-control" type="date" value="2018-10-22" id="eventDate" name="Date" value="">
		</div>
		<div class="form-group">
		  <label for="startTime">Start Time</label>
		  	<c:if test="${! empty Event name}">
 				<div class="alert alert-warning" role="alert" name="Description">
	  				${Event name}
				</div>
			</c:if>
		  <input class="form-control" type="time" value="12:15:00" id="startTime" name="Start" value="">
		</div>
		<div class="form-group">
		  <label for="endTime">End Time</label>
		  	<c:if test="${! empty Event name}">
 				<div class="alert alert-warning" role="alert" name="Description">
	  				${Event name}
				</div>
			</c:if>
		  <input class="form-control" type="time" value="12:15:00" id="endTime" name="End" value="">
		</div>
		<div class="form-group">
    		<label for="InputLocation">Event Location</label>
    			<c:if test="${! empty Event name}">
  					<div class="alert alert-warning" role="alert" name="Description">
		  				${Event name}
					</div>
				</c:if>
    		<input type="text" class="form-control" id="InputLocation" placeholder="Location">
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