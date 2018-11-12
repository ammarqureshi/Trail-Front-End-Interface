<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	
<head>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">

 <h2>Trails starting and ending in the same district </h2>
 
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



<table class="pure-table">
  <tr>
    <th>District</th>
    <th>Trail name</th>
    <th>Start Point</th>
    <th>End Point</th>
  </tr>  
  
  
	<c:forEach items="${results}" var="result">
		<tr>
			<c:forEach items="${result}" var="item">
				<td>${item}</td>
			</c:forEach>
		</tr>
	</c:forEach>
    
    
    
</table>
	
	
	<form action = "query" method = "GET">
		<input type = "submit"/>
	
	</form>
	
</body>
</html>
