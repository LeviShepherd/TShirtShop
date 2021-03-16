<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Customers</title>
</head>
<body>
	<form action="navigationServlet" method="post">
		<table>
			<c:forEach items="${requestScope.allCustomers}" var="currentcustomer">
			<tr>
				<td><input type="radio"name="id" value="${currentcustomer.customerId}"></td>
				<td><h2>${currentcustomer.name}</h2></td>
				<td colspan="3">Address: ${currentcustomer.address}</td>
			</tr>
			</c:forEach>
		</table>
		<input type ="submit" value ="edit" name="doThisToCustomer">
		<input type ="submit" value ="delete" name="doThisToCustomer">
		<input type="submit" value ="add" name ="doThisToCustomer">
	</form>
	<a href="index.html">Back to home</a>
</body>
</html>