<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>New Trip</title>
</head>
<body>

<h2><a href="/dashboard">Dashboard</a></h2>

<h1>Create a new trip</h1>

<form:form action="/trips/new" method="post" modelAttribute="trip">

	<table>
	    <thead>
	    	<tr>
	            <td class="float-left">Trip Title:</td>
	            <td class="float-left">
	            	<form:errors path="title" class="text-danger"/>
					<form:input class="input" path="title"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">Trip Plan:</td>
	            <td class="float-left">
	            	<form:errors path="plan" class="text-danger"/>
					<form:textarea rows="4" class="input" path="plan"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">Start Date:</td>
	            <td class="float-left">
	            	<form:errors path="startDate" class="text-danger"/>
					<form:input path="startDate" type="date"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">End  Date:</td>
	            <td class="float-left">
	            	<form:errors path="endDate" class="text-danger"/>
					<form:input path="endDate" type="date"/>
	            </td>
	        </tr>

	        <form:errors path="tripCreator" class="error"/>
			<form:input type="hidden" path="tripCreator" value="${userId}" class="form-control"/>

	        <tr>
	        	<td><a class="linkBtn" href="/dashboard">Cancel</a></td>
	        	<td><input class="input" type="submit" value="Submit"/></td>
	        </tr>
	    </thead>
	</table>
</form:form>
</body>
</html>
