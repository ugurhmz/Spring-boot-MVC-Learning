<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>


	<div class="container text-center">
		<h2 class="text-secondary">Low Security Page</h2>
		<div class="card-body bg-secondary my-3 text-white">
			<h3 >User Name : ${userName}</h3>
		</div>
	
		<a href="/logout" class="btn btn-danger mr-1">Logout</a> 
		<a href="/" class="btn btn-primary">Home</a>
	</div>
	



</body>
</html>