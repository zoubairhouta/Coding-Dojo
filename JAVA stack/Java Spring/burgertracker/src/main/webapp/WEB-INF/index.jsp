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
    <meta charset="UTF-8">
    <title>Burger</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h1>Burger Tracker</h1>
   
<table class="table">
  <thead>
    <tr>
      <th scope="col">Id of the burger in the database</th>
      <th scope="col">Burger Name </th>
      <th scope="col">Restaurant Name </th>
      <th scope="col">Rating (out of 5)</th>
      
    </tr>
  </thead>
  <tbody>
  
  
       <c:forEach var="burger" items="${burgers}">
         	<tr>
         		<th scope="row"><c:out value="${burger.id}"/></th>
         		<td><c:out value="${burger.name}"/></td>
         		<td><c:out value="${burger.restaurantName}"/></td>
         		<td><c:out value="${burger.rating}"/></td>
         	</tr>
         </c:forEach>
   
  </tbody>
</table>

<h2>Add a Burger</h2>
<form:form action="/burgers" method="post" modelAttribute="burger">
  <div class="mb-3">
    <form:label for="name" path="name" class="form-label">Burger Name</form:label>
    <form:input type="text" path="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
    <div id="emailHelp" class="form-text">Add a beautiful name of burger plz .</div>
  </div>
  <div class="mb-3">
    <form:label for="restaurantName" path="restaurantName" class="form-label">Restaurant Name</form:label>
    <form:input type="text" path="restaurantName" class="form-control" id="restaurantName"/>
  </div>
  <form:select name="rating"  path="rating"  aria-label=".form-select-lg example">
  
  <form:option value="1">1</form:option>
  <form:option value="2">2</form:option>
  <form:option value="3">3</form:option>
  <form:option value="4">4</form:option>
  <form:option value="5">5</form:option>
</form:select>


  <button type="submit" value = "Submit" class="btn btn-primary">Submit</button>
</form:form>

</body>
</html>

