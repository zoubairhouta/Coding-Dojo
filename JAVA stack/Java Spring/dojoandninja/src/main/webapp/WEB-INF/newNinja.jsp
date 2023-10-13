<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tacos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<h1>New Ninja</h1>
	<form:form modelAttribute="ninja" action="/ninja/new" method="post">
		<form:select path="dojo">
			<form:option value=""> --SELECT--</form:option>
			<c:forEach items="${dojos}" var="dojo">
				<form:option value="${dojo.id}">${dojo.name}</form:option>
			</c:forEach>
		</form:select>
		<div>
			<form:label path="firstName">First Name:</form:label>
			<br>
			<form:errors path="firstName" class="text-danger" />
			<form:input path="firstName" style="width:250px;" />
		</div>
		<div>
			<form:label path="lastName">Last Name:</form:label>
			<br>
			<form:errors path="lastName" class="text-danger" />
			<form:input path="lastName" style="width:250px;" />
		</div>
		<div>
			<form:label path="age">Age:</form:label>
			<br>
			<form:errors path="age" class="text-danger" />
			<form:input path="age" style="width:250px;" />
		</div>
		<div>
			<input type="submit" value="Create" />
		</div>
	</form:form>

</body>
</html>