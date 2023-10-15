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
    <title>Books</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <div class="container">
   
   <h1 class="monoton">All the Books 🔖</h1>
   <a href="/logout">Logout</a>
   <hr />
   <table class="table table-striped table-bordered"  >
   <thead>
   <tr>
   <th>ID</th>
   <th scope="col">Title</th>
   <th>Author</th>
   <th>Pages</th>
   <th>Publisher</th>
   <th>Actions</th>
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${listOfBooks }" var="oneBook">
   <tr>
		<td>${oneBook.id }</td>   
		<td>${oneBook.title }</td>   
		<td>${oneBook.author.userName }</td>   
		<td>${oneBook.pages }</td>   
		<td>
		<a href="/publishers/${oneBook.publisher.id }">${oneBook.publisher.name }   </a>
		</td>
		
		<td class="actions">
		<c:if test="${user_id eq oneBook.author.id }">
		<a href="/edit/${oneBook.id }" class="btn btn-secondary">edit</a> 
		<form action="/books/${oneBook.id }" method="post">
		<input type="hidden" name="_method" value="delete"/>
		<button class="btn btn-danger ms-3">delete</button>
		</form>
		</c:if>
		
		
		</td>

   </tr>
   </c:forEach>
   </tbody>
   </table>
   <hr />
<!--    create a form for book -->
<h1>Create Book 📰</h1>
<form:form action="/books" method="post" modelAttribute="book" class="col-3">
<form:errors path="*"/> 

    <p >
        <form:label path="title" class="form-label">Title</form:label>
       
        <form:input class="form-control" path="title"/>
    </p>
   
    <p>
        <form:label path="pages">Pages</form:label>    
        <form:input type="number" path="pages" class="form-control"/>
    </p>    
    <p>
	<form:select path="publisher" lass="dropdown" class="form-select" >
	<c:forEach items="${allPubs }" var="onePublisher">
		<form:option value="${onePublisher.id }">${onePublisher.name }</form:option>
	</c:forEach>
	
	</form:select>
    </p>    
    
    <button class="btn btn-success">Submit</button>
</div>
</form:form>    
   </div>
</body>
</html>