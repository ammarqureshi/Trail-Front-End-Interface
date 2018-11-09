<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>

<body>



	<div class="container">

		<div class="starter-template">
			<h2 class = "wrapper">${message}</h2>
		</div>

	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<br></br>
		<br></br>
		
		<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
		
		
		
		<form class = "wrapper" action="redirectQuery" method = "GET">
	  <select name="queryNum">	  
	    <option value="1">Number of trails per district</option>
	    <option value="2">Trails in your district</option>
	    <option value="3">What districts have a trail that are longer than X km</option>
	    <option value="4">What districts have a trail that have a quality greater than X</option>
	    <option value="5">What districts have a trail that has a climb of less than X m</option>
	    <option value="6">What trails have a circular format in X district</option>
	    <option value="7">What trails start and end in the same district</option>
	    <option value="8">Rank trails within a district based on Estimated Completion Time and that allow dogs</option>
	  </select>
	  
	  <input class="pure-button pure-button-primary" type="submit" value="Submit">
	
	</form>
	
	

</body>

</html>
