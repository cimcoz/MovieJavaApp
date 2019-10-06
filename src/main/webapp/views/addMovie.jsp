<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add movie form</title>
</head>
<body>
	<form action="add" method="post">
 		Enter movie name : <input type="text" name="name"><br>
 		Enter movie duration : <input type="text" name="duration"><br>
 		Enter movie type : <select name="type">
        <c:forEach items="${type}" var="typeIter">
            <option value="${typeIter}">${typeIter}</option>
        </c:forEach>
        </select><br>
 		Enter movie actors : <input type="text" name="actors"><br>
 		<input type="submit">
 	</form>
 	
 	

 	
 	
 	
</body>
</html>