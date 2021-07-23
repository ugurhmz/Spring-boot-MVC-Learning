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


Message : ${message} <br />
Id : ${emp.employeeId } <br />
Name : ${emp.employeeName } <br />
Salary : ${emp.monthlySalary } <br />



<a href="<c:url value='/employee/list' />">Employee Lists</a>

</body>
</html>