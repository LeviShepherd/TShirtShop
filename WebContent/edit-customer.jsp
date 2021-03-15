<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit an existing customer</title>
</head>
<body>
<form action="editCustomerServlet" method="post">
Customer Name: <input type="text" name="custName" value="${customerToEdit.name}">
Customer Address: <input type="text" name="address" value="${customerToEdit.address}">
<input type="hidden" name="id" value="${customerToEdit.customerId}">
<input type="submit" value="Save Customer">
</form>
</body>
</html>