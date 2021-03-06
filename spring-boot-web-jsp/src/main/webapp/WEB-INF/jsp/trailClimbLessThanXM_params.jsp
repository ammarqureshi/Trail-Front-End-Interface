<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

<body>
<h2>Enter a height in meters (eg. 1000)</h2>
	<h4>This query will return districts with trails that have a climb less than the input height</h4>
	<br>
<div>
	<form class="pure-form" action = "trailClimbLessThanXM" method = "GET">

  Districts with a trail climb of less than <input name="climb" type="text"> metres
 
                <br>
                <br>
        
 	<div class="wrapper">
	   <input class="pure-button pure-button-primary" type="submit" value="Query">
   </div>   
   </form>
   
   </div>
</body>
</html>