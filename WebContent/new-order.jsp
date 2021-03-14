<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new order</title>
</head>
<body>
<form action = "createNewOrderServlet" method="post">
Size: <input type="text" name="size"><br />
Color: <input type="text" name="color"><br />
Quantity: <input type="text" name="quantity"><br />
Date: <input type="text" name="month" placeholder="mm" size="4">
 <input type="text" name="day" placeholder="dd" size ="4">,
  <input type="text" name="year" placeholder="yyyy" size="4">
<input type="submit" value="Create order">
</form>
<a href="index.html">Go Home</a>
</body>
</html>