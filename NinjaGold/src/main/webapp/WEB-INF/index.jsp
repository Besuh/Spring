<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Your Gold: <c:out value="${gold}"/></h2>

	<div class="flex">
		<form action="/process/1" method="post">
			<h2>Farm</h2>
			<p>(earns 10-20 gold)</p>
			<input type="submit" value="Find Gold!"></input>
		</form>
	
		<form action="/process/2" method="post">
			<h2>Cave</h2>
			<p>(earns 5-10 gold)</p>
			<input type="submit" value="Find Gold!"></input>
		</form>
		
		<form action="/process/3" method="post">
			<h2>House</h2>
			<p>(earns 2-5 gold)</p>
			<input type="submit" value="Find Gold!"></input>
		</form>
		
		<form action="/process/4" method="post">
			<h2>Casino</h2>
			<p>(earns/takes 0-50 gold)</p>
			<input type="submit" value="Find Gold!"></input>
		</form>
	</div>

	<h2>Activities:</h2>
	<textarea id="activities">
		<c:out value="${res}"/>
	</textarea>
</body>
</html>