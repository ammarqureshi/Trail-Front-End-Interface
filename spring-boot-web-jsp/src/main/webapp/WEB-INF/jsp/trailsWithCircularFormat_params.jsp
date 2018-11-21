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
	<h4>This query will return the trails in your district that have a
		Circular format</h4>
	<br>
	<form class="pure-form pure-form-stacked"
		action="trailsWithCircularFormat" method="GET">

		Current Longitude (eg. -9.55247)<input class="forms" name="long" type="text"
			placeholder="Current longitude"> <span
			class="pure-form-message">This is a required field.</span> <br>
		<br> Current Latitude (eg. 51.74983)<input class="forms" name="lat" type="text"
			placeholder="Current latitude"> <span
			class="pure-form-message">This is a required field.</span> <br>
		<br>


		<div class="wrapper">

			<input class="pure-button pure-button-primary" type="submit"
				value="Submit">
		</div>
	</form>
</body>
</html>