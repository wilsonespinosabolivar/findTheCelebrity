<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>FindTheCelebrity</title>
	</head> 
	<body>
		<h2>${message}</h2>
		<form:form action="aftermath.html" method="post">
			<input type="submit" value="Let's find the celebrity">
			
		</form:form>
	</body>
</html>
