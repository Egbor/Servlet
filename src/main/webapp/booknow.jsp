<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Booking-book now</title>
	</head>
	<body>
		<form method="post" action="FrontController">
			<input type="hidden" name="command" value="LOGOUT_USER"/>
			<button type="submit">Logout</button>
		</form>
		<div>
			<c:set var="rooms" value="${requestScope.rooms}"/>
			<c:if test="${rooms.size() == 0}">
				<p>All rooms have been booked!</p>
			</c:if>
			<c:if test="${rooms.size() > 0}">
				<c:forEach var="room" items="${rooms}">
					<form method="post" action="FrontController">
						<input type="hidden" name="command" value="BOOK_ROOM_NOW"/>
						<input type="hidden" name="roomId" value="${room.getId()}"/>
						<input type="hidden" name="userId" value="${room.getUserId()}"/>
				
						<label for="user">User:</label>
						<input id="user" type="text" name="userTextField" value="${room.getUserId()}" readonly/>
						<label for="number">Number:</label>
						<input id="number" type="text" name="numberTextFiled" value="${room.getNumber()}" readonly/>
				
						<button type="submit">Book it now</button>
					</form>
				</c:forEach>
			</c:if>
		</div>
		<form method="post" action="FrontController">
			<input type="hidden" name="command" value="SHOW_ROOMS"/>
			<button type="submit">Back to user page</button>
		</form>
	</body>
</html>