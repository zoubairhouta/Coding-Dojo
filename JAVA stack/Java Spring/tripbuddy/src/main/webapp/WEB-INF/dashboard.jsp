<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Trip Manager Dashboard</title>
</head>
<body>

	<h1>Trip Buddies Dashboard</h1>
	<p>Welcome, ${user.firstName}</p>
	<p>
		<a href="/logout">Log Out</a>
	</p>
	<p>
		<a href="/trips/new">Create A new Trip</a>
	</p>



	<h4>Your Trips</h4>
	<table>
		<thead>
			<tr>
				<th>Destination</th>
				<th>Start date</th>
				<th>End Date Date</th>
				<th>Plan</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="trip" items="${assignedTrips}">
				<tr>
					<td><a href="/trips/${trip.id}">${trip.title}</a></td>

					<td><fmt:formatDate value="${trip.startDate}"
							pattern="MMMM dd" /></td>
					<td><fmt:formatDate value="${trip.endDate}" pattern="MMMM dd" /></td>
					<td><c:out value="${trip.plan}"></c:out></td>
					<td><c:if test="${trip.getTripCreator().id eq user.id}">
							<a href="/trips/delete/${trip.id}" style="margin-right: 30px;">
								remove </a>
							<a href="/trips/edit/${trip.id}">Edit Trip</a>
						</c:if> <c:if test="${trip.getUsers().contains(user) and trip.getTripCreator().id ne user.id  }">
							<a href="/trips/cancel/${trip.id}">Cancel</a>
						</c:if></td>


				</tr>
			</c:forEach>
		</tbody>
	</table>


	<h4>Other people's trips</h4>
	<table>
		<thead>
			<tr>
				<th>Destination</th>
				<th>Start date</th>
				<th>End Date Date</th>
				<th>Plan</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="trip" items="${unassignedTrips}">
				<tr>
					<td><a href="/trips/${trip.id}">${trip.title}</a></td>

					<td><fmt:formatDate value="${trip.startDate}"
							pattern="MMMM dd" /></td>
					<td><fmt:formatDate value="${trip.endDate}" pattern="MMMM dd" /></td>
					<td><c:out value="${trip.plan}"></c:out></td>

					<td><a href="/dashboard/join/${trip.id}">Join </a></td>


				</tr>
			</c:forEach>
		</tbody>
	</table>




</body>
</html>