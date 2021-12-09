<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<script type="text/javascript" src="js/language.js"></script>
	<head>
		<meta charset="UTF-8">
		<title>Booking</title>
	</head>
	<body>
		<button onclick=switchToEnglish()>En</button>
		<button onclick=switchToRussion()>Ru</button>
		<form method="post" action="FrontController">
			<input type="hidden" name="command" value="SIGN_UP_USER">
			<label class="lang-en" for="userlogin">Login:</label>
			<label class="lang-ru" for="userLogin">Логин:</label>
			<input name="userLogin">
			<label class="lang-en" for="userPassword">Password:</label>
			<label class="lang-ru" for="userPassword">Пароль:</label>
			<input type="password" name="userPassword">
			<button class="lang-en" type="submit">Sign up</button>
			<button class="lang-ru" type="submit">Зарегестрироваться</button>
		</form>
		<form method="post" action="FrontController">
			<input type="hidden" name="command" value="SIGN_IN_USER">
			<label class="lang-en" for="userlogin">Login:</label>
			<label class="lang-ru" for="userLogin">Логин:</label>
			<input name="userLogin">
			<label class="lang-en" for="userPassword">Password:</label>
			<label class="lang-ru" for="userPassword">Пароль:</label>
			<input type="password" name="userPassword">
			<button class="lang-en" type="submit">Sign in</button>
			<button class="lang-ru" type="submit">Войти</button>
		</form>
		<c:out value="${param.message}"/>
</body>
</html>