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

	
	<form:form method="post" modelAttribute="employee">
		<form:hidden path="employeeId"/>
		<form:errors/>
		
		<fieldset class="form-group">
			<form:label path="employeeId">Employee ID</form:label>
			<form:input path="employeeId" type="text" disabled="true"/>
			<form:errors path="employeeId"/>
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="employeeName">Employee Name</form:label>
			<form:input path="employeeName" type="text"/>
			<form:errors path="employeeName"/>
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="monthlySalary">Employee Salary</form:label>
			<form:input path="monthlySalary" type="text"/>
			<form:errors path="monthlySalary"/>
		</fieldset>
		
		<button type="submit">Save</button>
		
	</form:form>
</body>
</html>