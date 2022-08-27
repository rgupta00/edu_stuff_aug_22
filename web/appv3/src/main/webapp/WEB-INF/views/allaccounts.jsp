<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<thead>
			<tr>
				<th>accout id</th>
				<th>account holder name</th>
				<th>account balance</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="account" items="${accounts}">
				<tr>
					<td>${account.id}</td>
					<td>${account.name}</td>
					<td>${account.balance}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="create">create new account</a><br/>
	<a href="transfer">transfer</a><br/>
	<a href="deposit">deposit</a><br/>
	<a href="withdraw">withdraw</a><br/>
	
</body>
</html>