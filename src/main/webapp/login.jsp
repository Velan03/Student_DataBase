<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
	
	.from{
	
	background-color: blue;
	
	}

</style>

</head>
<body>

	<%
	String message=(String) request.getAttribute("msg"); 
	
	if(message != null){
		
	%>
	
	<h1><%=message %></h1>
	
	<%} %>

	<form action="login-in-form" >

		<input type="email" name="semail" placeholder="EMAIL"><br>
		<br> <input type="password" name="spassword"
			placeholder="PASSWORD"><br> <br>

		<button type="submit">Login</button>

	</form>

</body>
</html>