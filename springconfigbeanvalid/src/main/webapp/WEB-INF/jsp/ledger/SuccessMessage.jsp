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


	Message : ${message } <br />
	Account ID : ${account.accountId}<br/>
	Account Name : ${account.accountName } <br />
	Total Balance : ${account.totalBalance} <br />

</body>
</html>