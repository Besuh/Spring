<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${course.name }</title>
</head>
<body>
	<h1>${course.name }</h1>
	<h3>Instructor: ${course.instructor }</h3>
	
	<table class="table-bordered">
	<tr><th>Name</th></tr>
	<c:forEach items="${course.users}" var="s">
		<tr>
		<c:set var ="exist" scope = "session" value ="2"/>
		<c:forEach items="${ s.courses}" var ="x">
		<c:if test= "${ x.name == course.name }">
			<c:set var ="exist" scope = "session" value="1"/>
		</c:if>
		</c:forEach>
		<c:if test="${exist == 1 }">
			<td>${s.firstName }</td>
		</c:if>
		</tr>
	</c:forEach>
	</table>
	<a href="/courses/${course.id }/edit"><button>edit</button></a>
	<form action="/courses/${course.id }/delete">
		<input type="submit" value="Delete">
	</form>
</body>
</html>