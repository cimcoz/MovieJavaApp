<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index app page</title>
</head>
<body>
	What do you wanna do?
	<br>
	<br>
	<input type="button"  onclick="location.href='/movie/getAll'" value="Get All Movies" >
	<br>
	<br>
	<input type="button"  onclick="location.href='/movie/add'" value="Add Movie" >
	<br>
	<br>
	<input type="button"  onclick="location.href='/movie/delete'" value="Delete Movie (By Id or By Name)" >
	<br>
	<br>
	<input type="button"  onclick="location.href='/screenRoom/add'" value="AddScreenRoom" >
	<br>
	<br>
	<input type="button"  onclick="location.href='/broadcast/add'" value="AddBroadcast(you must have ScreenRoom in DB)" >
	<br>
	<br>
	<input type="button"  onclick="location.href='/client/sell'" value="SellTicket" >
</body>
</html>