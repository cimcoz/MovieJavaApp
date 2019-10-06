<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a screen room</title>
</head>
<body>
	<form action="add" method="post">
 		Enter screen room name : <input type="text" name="name"><br>
 		Enter screen room seats number : <input type="number" name="seats"><br>
 		<input type="submit">
 	</form>
 	${message}
</body>
</html>