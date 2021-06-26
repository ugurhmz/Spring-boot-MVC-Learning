<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Insert title here</title>
</head>
<body>

	<h3>List page </h3>
	<h4 style="font-size:2rem;font-family: bolder;color:purple;">${message}</h4>
	<table border="1">
		<c:forEach var="prd" items="${myProduct}">
			<tr>
				<td>${prd.productId}</td>
				<td>${prd.productName.toUpperCase()}</td>
				<td>${prd.salesPrice}</td>
				<td>
				
				<c:choose>
					<c:when test="${prd.salesPrice  > 2800}"> Fiyatı 2800'den büyüktür!</c:when>
					<c:otherwise>Fiyatı 2800'den küçüktür</c:otherwise>
				</c:choose>
				
				</td>
				
			</tr>
		</c:forEach>
	</table>

</body>
</html>