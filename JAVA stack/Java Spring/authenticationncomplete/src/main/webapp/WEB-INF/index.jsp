<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<div class="container">

    <!-- REGISTER A NEW USER -->
    <div class="login-reg-main border-round give-me-space-up-down">
        <h3>Register:</h3>
        <form:form action="/register"
                   method="post" modelAttribute="newUser">
            <div class="form-group">
                <label>User Name:</label>
                <form:input path="userName" class="form-control" />
                <form:errors path="userName" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Date of Birth:</label>
                <form:input path="dateOfBirth" type="date" class="form-control" />
                <form:errors path="dateOfBirth" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Country of Residence:</label>
                <form:input path="country" class="form-control" />
                <form:errors path="country" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Gender:</label>
                <form:input path="gender" class="form-control" />
                <form:errors path="gender" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Interests (Programming Languages):</label>
                <div class="form-check">
                    <form:checkbox path="programmingLanguages" value="Java" class="form-check-input" />
                    <label class="form-check-label">Java</label>
                </div>
                <div class="form-check">
                    <form:checkbox path="programmingLanguages" value="Python" class="form-check-input" />
                    <label class="form-check-label">Python</label>
                </div>
                <div class="form-check">
                    <form:checkbox path="programmingLanguages" value="JavaScript" class="form-check-input" />
                    <label class="form-check-label">JavaScript</label>
                </div>
                <!-- Add more programming languages as needed -->
                <form:errors path="programmingLanguages" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Email:</label>
                <form:input path="email" class="form-control" />
                <form:errors path="email" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Password:</label>
                <form:password path="password" class="form-control" />
                <form:errors path="password" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Confirm Password:</label>
                <form:password path="confirm" class="form-control" />
                <form:errors path="confirm" class="text-danger" />
            </div>
            <input type="submit" value="Register" class="btn btn-primary" />
        </form:form>
    </div>

    <!-- LOGIN -->
    <div class="login-reg-main border-round">
        <h3>Login:</h3>
        <form:form action="/login" method="post" modelAttribute="newLogin">
            <div class="form-group">
                <label>Email:</label>
                <form:input path="email" class="form-control" />
                <form:errors path="email" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Password:</label>
                <form:password path="password" class="form-control" />
                <form:errors path="password" class="text-danger" />
            </div>
            <input type="submit" value="Login" class="btn btn-success" />
        </form:form>
    </div>

</div>
</body>
</html>
