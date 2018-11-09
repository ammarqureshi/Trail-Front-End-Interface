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
<h2>Trails in District "${district}" </h2>

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
    <th>Trail name</th>
    <th>District</th>
  </tr>  
   <c:forEach items="${hmap}" var="distrTrails">
     <tr>
   		<td>${distrTrails.key} </td>
   		<td>${distrTrails.value}</td>
 	 </tr>
    </c:forEach>
</table>
	
	
	<form action = "query" method = "GET">
		<input type = "submit"/>
	
	</form>
	
</body>
</html>
