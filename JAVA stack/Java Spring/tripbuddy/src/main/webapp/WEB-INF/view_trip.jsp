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
<title>Trip Details</title>
</head>
<body>

<h2><a href="/dashboard">Dashboard</a></h2>

<h1>Trip Details</h1>
<table>
    <tbody>
    	<tr>
            <td>Trip: <c:out value="${trip.title}"></c:out></td>
        </tr>

        <tr>
            <td>Description: <c:out value="${trip.plan}"></c:out></td>
        </tr>

        <tr>
            <td>start Date: <fmt:formatDate value="${trip.startDate}" pattern="MMMM dd yyyy"/></td>
        </tr>
         <tr>
            <td>End Date: <fmt:formatDate value="${trip.endDate}" pattern="MMMM dd yyyy"/></td>
        </tr>
    </tbody>
</table>

<c:if test = "${trip.tripCreator.id==userId}">
    <h2><a href="/trips/delete/${trip.id}">Delete Trip</a></h2>
</c:if>

<h1>Prople who joined the trip</h1>
<table>
    <tbody>
    	<tr>
            <td>Trip: <c:out value="${trip.title}"></c:out></td>
        </tr>

        <tr>
            <td>Description: <c:out value="${trip.plan}"></c:out></td>
        </tr>

        <tr>
            <td>start Date: <fmt:formatDate value="${trip.startDate}" pattern="MMMM dd yyyy"/></td>
        </tr>
         <tr>
            <td>End Date: <fmt:formatDate value="${trip.endDate}" pattern="MMMM dd yyyy"/></td>
        </tr>
    </tbody>
</table>

</body>
</html>