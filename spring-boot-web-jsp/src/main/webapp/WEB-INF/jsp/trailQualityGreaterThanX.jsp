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

	
<head>
<h2>Districts with trail greater than quality of ${quality} </h2>

<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>




<table>
  <tr>
    <th>District</th>
    <th>Trail name</th>
    <th>Quality</th>
    
  </tr>  
   <c:forEach items="${trail}" var="trailList">
     <tr>
   		<td>${trail.district} </td>
   		<td>${trail.name}</td>
		<td>${trail.length}</td>
 	 </tr>
    </c:forEach>
</table>
	
	
	
	<form action = "query" method = "GET">
		<input class="pure-button pure-button-primary" type = "submit" value = "Query"/>
	</form>
	
	
</body>
</html>
