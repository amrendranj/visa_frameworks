<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guessing Game</title>
</head>
<body>
	<h1>Guessing Game</h1>
	<h3>Question:</h3>
	<br />
	<p>Which data structure is used if adding and removing is from
		arbitrary position and we need indexed operation</p>
	<h5>life left : ${life}</h5>
	<h5>Answer : ${currentAnswer}</h5>
	
	<form method="post" action="game">
		<input type="text" name="guess" />
		<button type="submit">Submit Query</button>
	</form>
</body>
</html>