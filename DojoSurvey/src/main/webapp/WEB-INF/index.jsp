<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dojo Survey index</title>
</head>
<body>
	<form action="/result" method="post">
		Your Name: <input type="text" name="name"><br>
		Dojo Location: <select name="location"><option value="sanjose">San Jose</option><option value="dc">DC</option></select><br>
		Comment(optional): <textarea rows="4" cols="32" name="comment"></textarea><br>
		<input type="submit">
	</form>
</body>
</html>