<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dto.*"%>




<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("title");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "finalproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
String userid = "root";
String password = "paroladb";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.header {
  padding: 10px 16px;
  background: #21610B;
  color: #f1f1f1;
}
/* Page content */
.content {
  padding: 16px;
}
/* The sticky class is added to the header with JS when it reaches its scroll position */
.sticky {
  position: fixed;
  top: 0;
  width: 100%
}
/* Add some top padding to the page content to prevent sudden quick movement (as the header gets a new position at the top of the page (position:fixed and top:0) */
.sticky + .content {
  padding-top: 102px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="header" id="myHeader">
  <center>
  <h2>Welcome to your personal page!</h2>
  </center>
</div>

 <title>Table with database</title>
 <style>
  table {
   border-collapse: collapse;
   width: 60%;
   color: #588c7e;
   font-family: monospace;
   font-size: 20px;
   text-align: center;
    overflow-y:scroll;
   height:280px;
   display:block;
     } 
  th {
   background-color: #588c7e;
   color: white;
    }
  tr:nth-child(even) {background-color: #f2f2f2}
 #myInput {
  background-position: 10px 12px; /* Position the search icon */
  width: 50%; /* Full-width */
  font-size: 16px; /* Increase font-size */
  padding: 12px 20px 12px 40px; /* Add some padding */
  border: 1px solid #ddd; /* Add a grey border */
  margin-bottom: 12px; /* Add some space below the input */
}
 </style>
</head>
<body>
 <h1>Hello,${name}</h1>

<table id="myTable">
  <tr class="header">
<td>Locations of concerts </td>

<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select location, price from tickets where username='"+request.getAttribute("name")+"'";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr">
<td><%=resultSet.getString("location") %></td>
<td>&nbsp&nbsp&nbsp&nbsp&nbsp<%=resultSet.getString("price") %>&nbsp&nbsp&nbsp&nbsp&nbsp</td>
<td><%=resultSet.getString("price") %></td>
<!--<td>&nbsp&nbsp&nbsp&nbsp&nbsp<input type="button" id= "myButton" value="Go to website" class="button"></td>-->


</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

<script>
 var table = document.getElementById('myTable');
 for(var i = 1; i < table.rows.length; i++)
 {
 table.rows[i].onclick = function()
 {
 	document.getElementById("locationname").value = this.cells[0].innerHTML;
  };
}
</script>
 <script>
 var x= document.getElementById("locationname").value;
 </script>
</table>

 <form method = "post" action="MetallicaServlet"> 
 	Locations:<input type="text" name="location" id="locationname"><br><br>
 	enter username:<input type="text" name="username" id="name"><br><br>
  <input type="submit" value="Finalize">
  <br><br>
</form>
</body>
</html>