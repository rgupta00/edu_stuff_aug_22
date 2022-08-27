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
<form:form action="withdraw" method="post" modelAttribute="withdrawDto">
	Enter  Account Id: <form:input path="accId"/><br/>
	Enter Amount to Withdraw: <form:input path="amount"/><br/>
	<input type="submit">
</form:form>
</body>
</html>