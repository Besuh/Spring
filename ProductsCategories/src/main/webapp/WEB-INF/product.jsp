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

	

	<form action="/add" method="post">
		<select name="category" >
			<c:forEach items="${categories}" var="category">
				<option value="${ category.id }" > ${category.name} </option>
			</c:forEach>
		</select>

		<select name="product">
			<c:forEach items="${products}" var="product">
				<option value="${ product.id }" > ${product.name} </option>
			</c:forEach>
		</select>
			
		<input type="submit" value="Add" />
	</form>
	
</body>
</html>