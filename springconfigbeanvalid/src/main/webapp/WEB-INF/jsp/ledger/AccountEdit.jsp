<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

		${message}<br />
	<form:form method="POST" modelAttribute="account" style="margin-top:2rem;">
		<form:hidden path="accountId" />
		<form:errors />
		
		<fieldset class="form-group">
				<form:label path="accountId">Id</form:label>
				<form:input path="accountId" type="text" disabled="true"/>
				<form:errors path="accountId" />
		</fieldset>
		
		<fieldset class="form-group">
				<form:label path="accountName">Account Name</form:label>
				<form:input path="accountName" type="text"/>
				<form:errors path="accountName" />
		</fieldset>
		
		<fieldset class="form-group">
				<form:label path="totalBalance">Total Balance</form:label>
				<form:input path="totalBalance" type="text"/>
				<form:errors path="totalBalance" />
		</fieldset>
		
		<button type="submit">Save </button>	
	</form:form>

</body>
</html>