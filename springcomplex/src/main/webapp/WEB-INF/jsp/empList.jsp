<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<form:form modelAttribute="employees" method="POST">
	
		<div class="form-group">
			<form:label path="departmentId"> Department </form:label>
			<form:select path="departmentId" class="form-control w-50">
				<form:option value="0">
						-- ALL --
				
				</form:option>
				
				<c:forEach items="${departments.departmentDetailList}" var="department">
					<form:option value="${department.departmentId }">
						${department.departmentName }
					</form:option>
				</c:forEach>
			</form:select>
			<button name="filter" class="btn btn-outline-primary mt-2" type="submit">Filter</button>
		</div>
		
		
	
	
	</form:form>
	
<table  style="margin-top:1rem;" class="table table-bordered">
	<thead>
		<tr>
		    <th>ID</th>
		    <th>NAME</th>
		    <th>SALARY</th>
		    <th>DEPARTMENT</th>
		    <th colspan="2">OPERATIONS</th>
		    
	  	</tr>
	</thead>
	
	<tbody>
	
		<c:forEach var="employee" items="${employees.employeeDetailList}">
			<tr >
			
				<td style="padding:5px 15px;">${employee.employeeId}</td>
				<td style="padding:5px 15px;"><strong>${employee.employeeName}</strong></td>
				<td style="padding:5px 15px;"><em>${employee.monthlySalary}</em></td>
				<td style="padding:5px 15px;"><strong>${employee.departmentName }</strong></td>
				<td style="padding:5px 15px;">
					<a href="<c:url   value='/employee/edit/${employee.employeeId}' />" class="btn btn-warning"> Update</a>
				</td>
				
				<td style="padding:5px 15px;">
					<a href="<c:url   value='/employee/delete/${employee.employeeId}' />" class="btn btn-danger"> Delete </a>
				</td>
				
			</tr>
		</c:forEach>
	
	</tbody>
</table>
<br />


<a href="<c:url  value='/employee/edit' />" class="btn btn-success">Add Employee</a>
</div>

</body>
</html>