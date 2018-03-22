<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>EDIT</h1>
	<c:out value="${ languages[i].name }"/>
	<c:out value="${ languages[i].creator }"/>
	<c:out value="${ languages[i].version }"/>
	<form action="/languages/update/${languages[i].ID }" method="post">
		Name <input type="text" name="name" value="${ languages[i].name }"><br>
		Creator <input type="text" name="creator" value="${languages[i].creator }"><br>
		Version <input type="text" name="version" value="${languages[i].version }"><br>
		<input type="submit" value="Submit">
	</form>
	

</body>
</html>