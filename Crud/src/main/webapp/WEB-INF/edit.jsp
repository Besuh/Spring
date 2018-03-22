<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>EDIT</h1>
	<c:out value="${ language.name }"/>
	<c:out value="${ language.creator }"/>
	<c:out value="${ language.version }"/>
	<form action="/languages/update/${language.ID }" method="post">
		Name <input type="text" name="name" value="${ language.name }"><br>
		Creator <input type="text" name="creator" value="${language.creator }"><br>
		Version <input type="text" name="version" value="${language.version }"><br>
		<input type="hidden" name="ID" value="${language.ID}")>
		<input type="submit" value="Submit">
	</form>


</body>
</html>