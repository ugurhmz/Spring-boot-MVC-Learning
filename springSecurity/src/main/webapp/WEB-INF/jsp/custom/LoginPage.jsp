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


	

	<div class="container my-3">

		<h1>Login Page</h1>
		
		<p class="text-danger text-center">${message}</p>
		
         
		
		<form name="login" action="/login" method="POST">
			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"/>
			 
			  <div class="form-group">
			    <label for="exampleInputEmail1">User Name</label>
			    <input type="text" class="form-control" name="username">
			    
			  </div>
			  
			  <div class="form-group">
			    <label for="exampleInputPassword1">Password</label>
			    <input type="password" class="form-control" name="password">
			  </div>
			 
			  <input type="submit" class="btn btn-primary" value="Login" />
		</form>
	</div>
	
	




</body>
</html>