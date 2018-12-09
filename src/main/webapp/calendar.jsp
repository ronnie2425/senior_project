<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Semantic UI - Calendar</title>
  <link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.print.min.css' rel='stylesheet' media='print' />
  
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.min.css'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.7/semantic.min.css'>

  
  
</head>

<body>

  <div class="ui container">

  <div class="ui menu">
    <div class="header item">Brand</div>
    <a class="active item">Link</a>
    <a class="item">Link</a>
    <div class="ui dropdown item">
      Dropdown
      <i class="dropdown icon"></i>
      <div class="menu">
        <div class="item">Action</div>
        <div class="item">Another Action</div>
        <div class="item">Something else here</div>
        <div class="divider"></div>
        <div class="item">Separated Link</div>
        <div class="divider"></div>
        <div class="item">One more separated link</div>
      </div>
    </div>
    <div class="right menu">
      <div class="item">
        <div class="ui action left icon input">
          <i class="search icon"></i>
          <input type="text" placeholder="Search">
          <button class="ui button">Submit</button>
        </div>
      </div>
      <a class="item">Link</a>
    </div>
  </div>
</div>

<br/>
<div class="ui container">
  <div class="ui grid">
    <div class="ui sixteen column">
      <div id="calendar"></div>
    </div>
  </div>
</div>

  <script src='https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.7/semantic.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.1/moment.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.min.js'></script>

  

    <script  src="js/calendar.js"></script>




</body>

</html>
