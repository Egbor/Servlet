<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Booking-admin</title>
	</head>
	<body>
		<form method="post" action="FrontController">
			<input type="hidden" name="command" value="LOGOUT_USER"/>
			<button type="submit">Logout</button>
		</form>
		<c:set var="rooms" value="${requestScope.rooms}"/>
		<c:if test="${rooms != null}">
			<c:forEach var="room" items="${rooms}">
				<form method="post" action="FrontController">
					<input type="hidden" name="command" value="CANCEL_BOOKING"/>
					<input type="hidden" name="roomId" value="${room.getId()}"/>
					<input type="hidden" name="userId" value="${room.getUserId()}"/>
				
					<label for="user">User:</label>
					<input id="user" type="text" name="userTextField" value="${room.getUserId()}" readonly/>
					<label for="number">Number:</label>
					<input id="number" type="text" name="numberTextFiled" value="${room.getNumber()}" readonly/>
				
					<c:if test="${room.checkReservation()}">
						<button type="submit">Cancel booking</button>
					</c:if>
					<c:if test="${!room.checkReservation()}">
						<button type="submit" disabled>Cancel booking</button>
					</c:if>
				</form>
			</c:forEach>
		</c:if>
	</body>
</html>