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

	
	<form:form method="POST" modelAttribute="employee">
		<fieldset class="form-group">
			<form:label path="employeeId">Employee ID</form:label>
			<form:input path="employeeId" type="text" disabled="true" />	
		</fieldset>
		
		<fieldset style="margin:1rem 0;" class="form-group">
			<form:label path="employeeName">Employee Name</form:label>
			<form:input path="employeeName" type="text" />	
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="monthlySalary">Employee Maaş: </form:label>
			<form:input path="monthlySalary" type="text"/>	
		</fieldset>	
		
		<button type="submit" style="margin-top:1rem;padding:.8rem;" > 
			Gönder
		</button>	
	</form:form>



</body>
</html>