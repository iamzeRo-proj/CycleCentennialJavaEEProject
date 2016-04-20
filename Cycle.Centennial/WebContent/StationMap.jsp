<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <meta http-equiv="content-type" content="text/html; charset=UTF-8" /> -->
<title>Station Maps | Cycle Centennial</title>
<!-- Core Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<!-- Navbar CSS -->
<link href="/resources/css/navbar.css">
<script src="http://maps.google.com/maps/api/js?sensor=false"
	type="text/javascript"></script>

</head>
<body>
	<div class="container">
	<div class="cover">
			<!-- google maps -->				
			<div id="map" style="width: 100%; height: 500px;"></div>

			<script type="text/javascript">
    				var locations = [
                     				["Centennial College - Morningside Campus", 43.7863105,-79.1952628, 3],
                     				['Centennial College - Progress Campus', 43.7847489,-79.2312502, 2],
                     				['Centennial College - Ashtonbee Campus', 43.7313444,-79.2946171, 1],
    								];

    				var map = new google.maps.Map(document.getElementById('map'), {
      					zoom: 12,
       					center: new google.maps.LatLng(43.75, -79.25),      
						/*  center: new google.maps.LatLng(43.7589753, -79.2635558), */
 						/* 43.7589753,-79.2635558 */
      					mapTypeId: google.maps.MapTypeId.ROADMAP
    					});

    				var infowindow = new google.maps.InfoWindow();

    				var marker, i;

   					for (i = 0; i < locations.length; i++) {  
      						marker = new google.maps.Marker({
        					position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        					map: map
      						});

      				google.maps.event.addListener(marker, 'click', (function(marker, i) {
        			return function() {
         				 infowindow.setContent(locations[i][0]);
         			 infowindow.open(map, marker);
       		 }
     	 })(marker, i));
    }
  </script>
  <!-- End Maps -->
  
  
  <!-- Reserver Bike -->
Reserve Bike: 
<select>
  <option value="pro">Progress</option>
  <option value="ash">Ashtonbee</option>
  <option value="morning">Morningside</option>
</select>
<button type="submit" value="Submit">Submit</button><!-- End Reserve Bike -->
<br>

<!-- Center Container -->
<table align="center">
	<tr><!-- Station Header -->
		<td>
			<h4>  Progress Campus Station Map</h4>
		</td>
		<td>
			<h4>  Morningside Campus Station Map</h4>
		</td>
		<td>
			<h4>  Ashtonbee Campus Station Map</h4>
		</td>
	</tr>
	
	<tr>
		<td>
			Total Bikes at this Station:
<br>  
Available Bikes:
<br>
Out of Service:
</td>
<td>
Total Bikes at this Station:
<br>  
Available Bikes:
<br>
Out of Service:
</td>
<td>
Total Bikes at this Station:
<br>  
Available Bikes:
<br>
Out of Service:
</td>
</tr>
</table><!-- End Center Container -->
	</div>
	</div>


					
</body>
</html>