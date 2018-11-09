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
<h1>Districts with trails longer than ${length} km</h1>

</head>

<table>
  <tr>
    <th>District</th>
    <th>Trail name</th>
    <th>Trail length in km</th>
    
  </tr>  
   <c:forEach items="${trailList}" var="trail">
     <tr>
   		<td>${trail.getDistrict()} </td>
   		<td>${trail.getName()}</td>
		<td>${trail.getLength()}</td>
 	 </tr>
    </c:forEach>
</table>
	
	
	<form action = "query" method = "GET">
		<input type = "submit"/>
	
	</form>
	
</body>
</html>
