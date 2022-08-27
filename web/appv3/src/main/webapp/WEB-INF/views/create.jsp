<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BigBang Bank create new account</title>
</head>
<body>
<form:form action="create" method="post" modelAttribute="accountDto">
	Enter  Account Id: <form:input path="id"/><br/>
	Enter  Account holder name: <form:input path="name"/><br/>
	Enter Initial amount: <form:input path="balance"/><br/>
	<input type="submit">
</form:form>
</body>
</html>