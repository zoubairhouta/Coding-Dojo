<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>Send an Omikuji</h1>
		<form action="/processForm" method = "POST">
			<div class="form-group">
				<label>Pick any number from 5 to 25</label> 
				<input type="number" name="number" min="5" max="25" class="form-control"></input>
			</div>
			<div class="form-group">
				<label>Enter the name of any city</label>
				<input type="text" name="city" class="form-control"></input>
			</div>
			<div class="form-group">
				<label>Enter the name of any real person</label>
				<input type="text" name="person" class="form-control"></input>				
			</div>
			<div class="form-group">
				<label>Enter professional endeavor or hobby</label>
				<input type="text" name="hobby" class="form-control"></input>
			</div>
			<div class="form-group">
				<label>Enter any type of living thing</label>
				<input type="text" name="livingThing" class="form-control"></input>
			</div>
			<div class="form-group">
				<label>Say something nice to someone</label>
				<textarea class="form-control" rows="3" name="messege"></textarea>			
			</div>
			<p>Send and show a friend</p>	
			<button type="submit" class="btn btn-primary">Send</button>		
		</form>		
		
	</div>	
</body>
</html>