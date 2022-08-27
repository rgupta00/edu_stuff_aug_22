<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BigBang Bank</title>
</head>
<body>
<form:form action="transfer" method="post" modelAttribute="transferDto">
	Enter from Account Id: <form:input path="fromId"/><br/>
	Enter to Account Id: <form:input path="toId"/><br/>
	Enter Amount to transfer: <form:input path="amount"/><br/>
	<input type="submit">
</form:form>
</body>
</html>