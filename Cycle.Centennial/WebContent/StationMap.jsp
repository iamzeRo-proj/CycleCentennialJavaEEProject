<%@page import="com.dao.BikeInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />


<title>Station Maps | Cycle Centennial</title>

<!-- Core Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<!-- Navbar CSS -->
<link href="./resources/css/navbar-alt.css" rel="stylesheet" />
<!-- Core CSS -->
<link href="./resources/css/main.css" rel="stylesheet" />

<script src="http://maps.google.com/maps/api/js?sensor=false"
	type="text/javascript"></script>

</head>
<body>
	<div id="register">
		<div class="navwrapper">
			<!-- Navbar -->
    		<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    		<span class="sr-only">Toggle navigation</span>
                    		<span class="icon-bar"></span>
                    		<span class="icon-bar"></span>
                    		<span class="icon-bar"></span>
                		</button>
                		<a class="navbar-brand" href="login.xhtml"><img id="brand-image" src="./resources/img/cycleCentennial-logo.png"/></a>
                		<ul class="nav navbar-nav">
              				<li><a href="/Cycle.Centennial/faces/admin.xhtml"><h5>Home</h5></a></li>
              				<li><a href="about.html"><h5>About</h5></a></li>
              			</ul>
              		</div><!-- End of navbar-header div class -->
				</div><!-- End of container-fluid div class -->
		    </nav><!-- End of navbar navbar-default div class -->
		    <!-- google maps -->				
			<div id="map" style="width: 100%; height: 500px; padding: 0 0 0 0">
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
			</div><!-- End Maps -->
			
			<!-- Reserver Bike -->
			<div class="row" style="align: center;">
					<div class="col-md-3">
						<table>
							<%BikeInfoDAO bikeDao = new BikeInfoDAO(); %>
								<tr>
								<form action="/Cycle.Centennial/ReserveBikeServlet" method = "post">
									<td><h4>Reserve Bike:</h4></td>
								</tr>
								<br />
								<tr>
									<td>
										<select name="location">
											  <option value="progress">Progress</option>
											  <option value="ashtonbeesh">Ashtonbee</option>
											  <option value="morningside">Morningside</option>
										</select>
									</td>
									<td><button type="submit" value="Submit">Submit</button></td>
								</tr>
								</form>
						</table>
					</div>
					<div class="col-md-3">
						<table>
							<tr><td><h4>  Progress Campus Station Map</h4><td></tr>
							<tr><td>Total Bikes at this Station: <% out.println(bikeDao.getBikeInfo("progress").size()); %></td></tr>
							<tr><td>Available Bikes: <% out.println(bikeDao.getBikeInfo("available","progress").size()); %></td></tr>
							<tr><td>Out of Service:<% out.println(bikeDao.getBikeInfo("out","progress").size()); %></td></tr>
						</table>
					</div>
					<div class="col-md-3">
						<table>
							<tr><td><h4>  Ashtonbee Campus Station Map</h4><td></tr>
							<tr><td>Total Bikes at this Station: <% out.println(bikeDao.getBikeInfo("ashtonbee").size()); %></td></tr>
							<tr><td>Available Bikes: <% out.println(bikeDao.getBikeInfo("available","ashtonbee").size()); %></td></tr>
							<tr><td>Out of Service:<% out.println(bikeDao.getBikeInfo("out","ashtonbee").size()); %></td></tr>
						</table>
					</div>
					<div class="col-md-3">
						<table>
							<tr><td><h4>  Progress Campus Station Map</h4><td></tr>
							<tr><td>Total Bikes at this Station: <% out.println(bikeDao.getBikeInfo("morningside").size()); %></td></tr>
							<tr><td>Available Bikes: <% out.println(bikeDao.getBikeInfo("available","morningside").size()); %></td></tr>
							<tr><td>Out of Service:<% out.println(bikeDao.getBikeInfo("out","morningside").size()); %></td></tr>
						</table>
					</div>

			</div><!-- End Div row -->
			  
		</div>
	</div>		
	
</body>
</html>