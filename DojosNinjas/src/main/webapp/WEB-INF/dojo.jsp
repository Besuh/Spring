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

<h1>New Dojo</h1>
	<form:form method="post" action="/dojos/new" modelAttribute="dojo">
		<form:label path="name">Name: 
		<form:errors path="name"/>
		<form:input path="name"/></form:label>
		<input type="submit" value="submit">
	</form:form>

</body>
</html>