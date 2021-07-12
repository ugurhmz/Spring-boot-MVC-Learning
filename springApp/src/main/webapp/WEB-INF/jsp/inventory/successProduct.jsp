<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Insert title here</title>
</head>
<body>

	<p>${ message }</p>
	Product ID : ${product.productId } <br/>
	Product Name : ${product.productName } <br />
	Product SalesPrice : ${product.salesPrice } <br />

	<p>
		<a href="/product/addproduct" 
			style="background-color: blue;padding:5px; color:white;border-radius:5px;font-weight: bolder">
			Back To Page
		</a>
	</p>

</body>
</html>