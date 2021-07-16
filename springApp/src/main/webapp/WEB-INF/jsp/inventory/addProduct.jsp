<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>

	
	<form:form method="POST" modelAttribute="product">
		<form:errors/>
		 <form:hidden path="productId"/>
		
		<fieldset class="form-group">
			<form:label path="productId">Product ID</form:label>
			<form:input class="form-control"  path="productId" type="text" disabled="true" />	
		</fieldset>
		
		<fieldset style="margin:1rem 0;" class="form-group">
			<form:label path="productName">Product Name</form:label>
			<form:input class="form-control w-50" path="productName" type="text" />	
			<form:errors path="productName" />
			
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="salesPrice">SalesPrice : </form:label>
			<form:input class="form-control w-25" path="salesPrice" type="text"/>	
			<form:errors path="salesPrice" />
			
		</fieldset>	
		
		<button type="submit"  class="btn btn-success ml-2" > 
			Save Product
		</button>	
	</form:form>

	<p>
		<a href="/product/productList" 
			 class="btn btn-primary mt-2 ml-2">
			Product List
		</a>
	</p>
	
	


</body>
</html>