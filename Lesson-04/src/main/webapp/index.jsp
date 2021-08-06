<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Hello World</title>

</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	
	<form action="registration" method="post">
		<label for="firstname">First Name :</label> <input name="firstname">
		
		<label for="lastname">Last Name :</label> <input name="lastname">
		
		<label for="email">Email :</label> <input name="email">
		
		<label for="password">Password :</label> <input name="password">
		
		<input type="submit" value="submit">
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>