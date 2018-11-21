<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

<body>
	<h2>Enter your current Latitude and Longitude</h2>
	<h4>This query will return the trail names in your district</h4>
	<br>

	<form class="pure-form" action="trailsInYourDistrict" method="GET">
		Trails near <input name="lat" type="text"
			placeholder="current latitude">, <input name="long"
			type="text" placeholder="current longitude"> (eg. 51.74983, -9.55247)<br> <br>
		<div class="wrapper">

			<input class="pure-button pure-button-primary" type="submit"
				value="Query">
		</div>
	</form>
</body>
</html>