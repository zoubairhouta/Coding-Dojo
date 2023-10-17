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
<title>Edit Trip</title>
</head>
<body>

<h2><a href="/dashboard">Dashboard</a></h2>

<h1>Edit Trip</h1>

<form:form action="/trips/edit/${trip.id}" method="post" modelAttribute="trip">

	<table>
	    <thead>
	    	<tr>
	            <td class="float-left">Trip Title:</td>
	            <td class="float-left">
	            	<form:errors path="title" class="text-danger"/>
					<form:input class="input" path="title" value="${trip.title}"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">Trip plan:</td>
	            <td class="float-left">
	            	<form:errors path="plan" class="text-danger"/>
					<form:textarea rows="4" class="input" path="plan" value="${trip.plan}"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">start Date:</td>
	            <td class="float-left">
	            	<form:errors path="startDate" class="text-danger"/>
					<form:input path="startDate" type="date" value="${trip.startDate}"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">end Date:</td>
	            <td class="float-left">
	            	<form:errors path="endDate" class="text-danger"/>
					<form:input path="endDate" type="date" value="${trip.endDate}"/>
	            </td>
	        </tr>
	        <tr>
	        	<td><a class="linkBtn" href="/dashboard">Cancel</a></td>
	        	<td><input class="input" type="submit" value="Submit"/></td>
	        </tr>
	    </thead>
	</table>
</form:form>
</body>
</html>