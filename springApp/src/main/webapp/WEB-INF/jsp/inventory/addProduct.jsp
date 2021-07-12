<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	
	<form:form method="POST" modelAttribute="product">
		<form:errors/>
	
		<fieldset class="form-group">
			<form:label path="productId">Product ID</form:label>
			<form:input path="productId" type="text" disabled="true" />	
		</fieldset>
		
		<fieldset style="margin:1rem 0;" class="form-group">
			<form:label path="productName">Product Name</form:label>
			<form:input path="productName" type="text" />	
			<form:errors path="productName" />
			
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="salesPrice">SalesPrice : </form:label>
			<form:input path="salesPrice" type="text"/>	
			<form:errors path="salesPrice" />
			
		</fieldset>	
		
		<button type="submit" style="margin-top:1rem;padding:.8rem;" > 
			Gönder
		</button>	
	</form:form>



</body>
</html>