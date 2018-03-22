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
	<c:out value="${ x.name }"/>
	<table>
		<tr> <th>First Name<th>Last Name <th>age</tr>
	<c:forEach items="${ ninjas }" var="ninja" varStatus="loop">
		<tr>
			<td><c:out value="${ninja.first_name }"/></td>
			<td><c:out value="${ninja.last_name }"/></td>
			<td><c:out value="${ninja.age }"/></td>
	
	</c:forEach>
	</table>
</body>
</html>