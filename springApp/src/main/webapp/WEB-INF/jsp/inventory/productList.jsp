<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>

	
	<h1>${message }</h1>
	
	<br />
	<div>
	<table border="1" style="padding:1rem;" class="table">
	
		
		
		 <thead>
			    <tr>
			      
			      <th scope="col">ID</th>
			      <th scope="col">PRODUCT NAME</th>
			      <th scope="col">SALES PRICE</th>
			    </tr>
		  </thead>
	
		<tbody>
			<c:forEach var="product" items="${productlist}">	
				<tr>
					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.salesPrice}</td>
					
					<td><a href="<c:url value='/product/update/${product.productId}' />" class="btn btn-warning">Update</a></td>
					
					<td><a href="<c:url value='/product/delete/${product.productId}' />" class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>	
	
	</table>
	
	
	<p>
		<a href="/product/addproduct" 
			class="btn btn-success mt-2">
			Add To Product
		</a>
	</p>
	
	</div>
	
	
	
</body>
</html>