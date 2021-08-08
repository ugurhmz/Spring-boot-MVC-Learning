<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib   prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>


	<div class="container text-center">
		<h2>Partial Page</h2>
		
	</div>
	
	<security:authorize access="hasRole('ADMIN')">
		
		<h1>Admin access</h1>
		<a href="/logout"></a>
	</security:authorize>


	<security:authorize access="hasRole('USER')">
		<h3>User access</h3>
		<a href="/logout"></a>
	</security:authorize>


</body>
</html>