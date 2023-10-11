<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>  
<h1>All Books</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
         <!-- loop over all the books to show the details as in the wireframe! -->
        
   
          <c:forEach var="book" items="${books}">
          
  <tr> 
  <td><c:out value="${book.id}"></c:out></td>
  <td><a href="/books/${book.id}"><c:out value="${book.title}"></a></c:out></td>
  <td><c:out value="${book.language}"></c:out></td>
  <td><c:out value="${book.numberOfPages}"></c:out></td>
  
  
  </tr>
    </c:forEach>
         
     
 

    </tbody>
</table>
