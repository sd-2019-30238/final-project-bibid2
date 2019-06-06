<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<form action="RegisterServlet" method="post">

	<br>
	<br>
	<br>
	<br>
	 <center>
    <b>First name:</b> <input type="text" name="first"/><br>
    <b>Last name:</b> <input type="text" name="last"/><br>
    <b>Email:</b><input type="text" name="username"/><br>
    <b>Password:</b> <input type="password" name="password" /><br>
    <b>Rewrite password:</b> <input type="password" name="password1" /><br>
    *Payment can be weekly, montly or yearly and cash only
    <br>
   <input type="submit" value="Register"/>
    </center>    
    

</form>

</body>
</html>