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
		
	<form  class="pure-form pure-form-stacked" action = "numOfTrailsPerDistrict" method = "GET">

  Current Lat <input class = "forms" name="lat" type="text"  placeholder = "Current latitude">
          <span class="pure-form-message">This is a required field.</span>
  
            <br>
            <br>
  Current Long <input class = "forms" name="long" type="text" placeholder = "Current longitude">
            <span class="pure-form-message">This is a required field.</span>
  
           <br>
          
   <div class="wrapper">
          
	   <input class="pure-button pure-button-primary" type="submit" value="Submit">
   </div>
   
   

	
  
   </form>
   
   
</head>
<body>

</body>
</html>