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

	<h2>Enter a distance in kilometres (eg. 20)</h2>
	<h4>This query will return districts with trails longer than the input distance</h4>
	<br>


	<div>
		<form class="pure-form" action="trailsLongerThanXKm" method="GET">

			Trails longer than <input name="length" type="text"> kms <br>
			<div class="wrapper">
				<input class="pure-button pure-button-primary" type="submit"
					value="Query">
			</div>
		</form>

	</div>
</body>
</html>