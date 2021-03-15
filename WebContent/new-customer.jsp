<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a new customer</title>
</head>
<body>
<form action = "addCustomerServlet" method="post">
Customer Name: <input type="text" name="name"><br />
Customer Address: <input type="text" name="address"><br />
<input type="submit" value="Add Customer">
</form>
<a href="index.html">Go back home</a>
</body>
</html>