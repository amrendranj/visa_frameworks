<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@         taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online chat</title>
</head>
<body>
	<h1>Welcome to "${Company}": "${user}" </h1>
	<a href="LoginServlet">Log out</a>
	<form action="ChatServlet" method="post">
		<input type="text" name="msg" required />
		<button type="submit">Send Message</button>
	</form>
	<c:forEach items="${messages}" var="m">
		${m} <br />
	</c:forEach>
</body>
</html>