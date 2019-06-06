<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Your books everywhere!!</h1>
	<br>
	<br>
	<form method="post" action="LoginServlet">

		<b>Username:</b> <input type="text" name="username"><br>
		<b>Password:</b> <input type="password" name="password"><br>
		<input type="submit" value="Login">

	</form>
	<br>
	<h3> You don't have an account? Register here: </h3><a href="CreateAccount.jsp">Register</a>
</body>
</html>