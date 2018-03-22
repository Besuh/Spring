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
	<table>
		<tr>
			<th>Name <th>Creator <th>Version <th>action</th>
		</tr>
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
	</table>
	<br>
	<form:form method="post" action="/languages/add" modelAttribute="language">
		<form:label path="name">Name
		<form:errors path="name"/>
		<form:input path="name"/></form:label>
		
		<form:label path="creator">Creator
		<form:errors path="creator"/>
		<form:input path="creator"/></form:label>
		
		<form:label path="version">Version
		<form:errors path="version"/>
		<form:input path="version"/></form:label>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>