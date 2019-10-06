<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy a ticket</title>
</head>
<body>
	<form action="sell" method="post">
 		Enter client name : <input type="text" name="name"><br>
 		Enter client email : <input type="email" name="email"><br>
 		Enter client phone : <input type="text" name="phone"><br>
 		Enter broadcast date : <select name="date">
        <c:forEach items="${broadcastDates}" var="broadcastDate">
            <option value="${broadcastDate}">${broadcastDate}</option>
        </c:forEach>
        </select><br>
 		
 		
 		<!-- <input type="datetime-local" name="date"><br>-->
 		<input type="submit">
 	</form>
</body>
</html>