<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
    <h1>Welcome <c:out value="${currentUser.firstName}"></c:out>!</h1>
  
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout" />
    </form>
    
    <table class="table-bordered">
    <tr><th>Course</th><th>Instructor</th><th>Signups</th><th>Action</th></tr>
    <c:forEach items="${courses }" var="x">
    	<tr> <td><a href="/courses/${x.id}">${x.name }</a></td>
    		<td>${x.instructor }</td>
    		<c:if test="${x.users.size() == x.limi }">
    		<td>${x.users.size()} / ${x.limi }</td>

    		
    		<td><a>Full</a></td>
    		</c:if>
    		<c:if test="${x.users.size() < x.limi }">
    		<td>${x.users.size()} / ${x.limi }</td>
    		<c:set var = "exist" scope = "session" value ="2"/>
    		<c:forEach items="${x.users }" var="y">
    			<c:if test="${y.firstName == currentUser.firstName}">
    				<c:set var = "exist" scope = "session" value ="1"/>
    			</c:if>
    		</c:forEach>
    		<c:if test="${exist == 1 }">
    			<td>You've already joined</td>
    		</c:if>
    		<c:if test="${exist ==2 }">
    		<td><a href="/courses/${x.id}/join">join</a></td>
    		</c:if>
    		</c:if>
    	</tr>
    </c:forEach>
    </table>
    
    <a href="/courses/new"><button>New Course</button></a>
</body>
</html>