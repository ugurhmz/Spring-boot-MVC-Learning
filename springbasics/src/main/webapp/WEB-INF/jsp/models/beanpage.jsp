<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Insert title here</title>
</head>
<body>


	<h1>Bean page</h1>
	<h2 style="font-size:1.5rem;color:olive;">${productMessage}</h2>
	
	<p><strong> Product ID : </strong> ${product.productId}</p>
	<p><strong> Product Name : </strong> ${product.productName}</p>
	<p><strong> Product Sales Price : </strong> ${product.salesPrice}$</p>


</body>
</html>