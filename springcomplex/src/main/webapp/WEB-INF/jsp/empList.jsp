<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	
	<c:forEach var="employee" items="${employees.employeeDetailList}">
		<tr>
		
			<td>${employee.employeeId}</td>
			<td>${employee.employeeName}</td>
			<td>${employee.monthlySalary}</td>
			<td><a href="<c:url  value='/employee/edit/${employee.employeeId}' />"> Update</a></td>
			<td><a href="<c:url  value='/employee/delete/${employee.employeeId}' />"> Delete </a></td>
			
		</tr>
	</c:forEach>
</table>
<br />


<a href="<c:url  value='/employee/edit' />">Add Employee</a>


</body>
</html>