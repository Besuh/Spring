<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
		<form:form action="/products/new" method="post" modelAttribute="product">
			<form:label path="name">Name:
				<form:errors path="name"></form:errors>
				<form:input type="text" path="name"></form:input>
			</form:label>

			<form:label path="description">Description:
				<form:errors path="description"></form:errors>
				<form:input type="text" path="description"></form:input>
			</form:label>
			
			<form:label path="price">Price:
				<form:errors path="price"></form:errors>
				<form:input type="number" path="price"></form:input>
			</form:label>

			<input type="submit" value="Create Product" />
		</form:form>
	
</body>
</html>