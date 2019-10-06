<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%! int index; %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get all movies from DB</title>
</head>
<body>
	Movies that are in the DB:
	<br>
 	<c:forEach items="${result}" var="item">
            <br>
            <c:out value="MovieName: -----${item.name}-----"/> <c:out value="MovieId: -------${item.id}"/>
        </c:forEach>
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