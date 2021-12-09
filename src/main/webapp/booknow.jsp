<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<script type="text/javascript" src="js/language.js"></script>
	<head>
		<meta charset="UTF-8">
		<title>Booking-book now</title>
	</head>
	<body>
		<form method="post" action="FrontController">
			<input type="hidden" name="command" value="LOGOUT_USER"/>
			<button class="lang-en" type="submit">Sign out</button>
			<button class="lang-ru" type="submit">Выйти</button>
		</form>
		<div>
			<c:set var="rooms" value="${requestScope.rooms}"/>
			<c:if test="${rooms.size() == 0}">
				<p class="lang-en">All rooms have been booked!</p>
				<p class="lang-ru">Все номера были забронированы!</p>
			</c:if>
			<c:if test="${rooms.size() > 0}">
				<c:forEach var="room" items="${rooms}">
					<form method="post" action="FrontController">
						<input type="hidden" name="command" value="BOOK_ROOM_NOW"/>
						<input type="hidden" name="roomId" value="${room.getId()}"/>
						<input type="hidden" name="userId" value="${room.getUserId()}"/>
				
						<label class="lang-en" for="user">User id:</label>
						<label class="lang-ru" for="user">Id пользователя:</label>
						<input id="user" type="text" name="userTextField" value="${room.getUserId()}" readonly/>
						<label class="lang-en" for="number">Number:</label>
						<label class="lang-ru" for="number">Номер:</label>
						<input id="number" type="text" name="numberTextFiled" value="${room.getNumber()}" readonly/>
				
						<button class="lang-en" type="submit">Book it now</button>
						<button class="lang-ru" type="submit">Забронировать</button>
					</form>
				</c:forEach>
			</c:if>
		</div>
		<form method="post" action="FrontController">
			<input type="hidden" name="command" value="SHOW_ROOMS"/>
			<button class="lang-en" type="submit">Back to user page</button>
			<button class="lang-ru" type="submit">Вернуться на строницу пользователя</button>
		</form>
	</body>
</html>