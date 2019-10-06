<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add movie form</title>
</head>
<body>
	<form action="deleteById" method="delete">
 		Delete movie with id : <select name="id">
        <c:forEach items="${movieIds}" var="movieId">
            <option value=${movieId}>${movieId}</option>
        </c:forEach>
        </select><br>
 		<input type="submit">
 	</form>
 	<br>
 	<br>
 	<form action="deleteByName" method="delete">
 		Delete movie with name : 
 		<select name="name">
        <c:forEach items="${movie}" var="movieName">
            <option value="${movieName}">${movieName}</option>
        </c:forEach>
        </select><br>
 		<input type="submit">
 	</form>
</body>
</html>