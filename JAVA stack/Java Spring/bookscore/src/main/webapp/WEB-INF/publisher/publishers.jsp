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
<title>Publishers</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
	<h1>All Publishers</h1>
	<hr />
	
<!--    	Publishers List -->
<ul>
<c:forEach items="${ PublishersList}" var="onePublisher">
	<li>${onePublisher.name }</li>
	<p>${onePublisher.location }</p> 	 	
</c:forEach>
</ul>
	<!--    Create Publisher Form -->
	<form:form action="/pubs" method="post" modelAttribute="publisher">
		<div>
			<form:label path="name">Name: </form:label>
			<form:errors path="name"></form:errors>
			<form:input path="name" />
		</div>

		<div>
			<form:label path="location">Location: </form:label>
			<form:errors path="location"></form:errors>
			<form:input path="location" />
		</div>
		<button>Submit</button>
	</form:form>

</div>
</body>
</html>