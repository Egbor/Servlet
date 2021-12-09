<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Booking</title>
</head>
<body>
	<form method="post" action="FrontController">
		<input type="hidden" name="command" value="SIGN_UP_USER">
		<input name="userLogin">
		<input type="password" name="userPassword">
		<button type="submit">Sign up</button>
	</form>
	<form method="post" action="FrontController">
		<input type="hidden" name="command" value="SIGN_IN_USER">
		<input name="userLogin">
		<input type="password" name="userPassword">
		<button type="submit">Sign in</button>
	</form>
	<c:out value="${param.message}"/>
	
<!-- <form method="post" action="FrontController">
		<input type="hidden" name="command" value="GET_ALL_USERS">
		<button type="submit">Show</button>
	</form>
	<c:set var="users" value="${requestScope.users}"/>
	<c:if test="${users != null}">
		<c:forEach var="user" items="${users}">
			<c:out value="${user.getId()}"/>
			<c:out value="${user.getLogin()}"/>
			<c:out value="${user.getPassword()}"/>
		</c:forEach>
	</c:if> -->
</body>
</html>