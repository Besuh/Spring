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
	Language page
	
	<c:forEach items="${languages }" var="language" varStatus="loop">
		<tr>
			<td><c:out value="${language.name}"/></td>
			<td><c:out value="${language.creator}"/></td>
			<td><c:out value="${language.version}"/></td>
			<td><a href="/languages/edit/${language.ID}">edit</a>
			<form action="post" action="/languages/delete/${language.ID}">
				<input type="button" value="delete">
			</form>
		</tr>
	</c:forEach>
</body>
</html>