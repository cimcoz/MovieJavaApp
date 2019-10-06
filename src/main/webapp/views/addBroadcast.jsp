<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add broadcast for a movie</title>
</head>
<body>
	<form action="add" method="post">
 		Enter movie name : <select name="name">
        <c:forEach items="${movie}" var="movieName">
            <option value="${movieName}">${movieName}</option>
        </c:forEach>
        </select><br>
 		Enter date for the movie : <input type="datetime-local" name="date"><br>
 		Enter screen room name: <select name="screenRoomName">
        <c:forEach items="${screenRooms}" var="screenRoom">
            <option value="${screenRoom}">${screenRoom}</option>
        </c:forEach>
        </select><br>
 		<input type="submit">
 	</form>
</body>
</html>