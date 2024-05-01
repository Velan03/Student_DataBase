<%@page import="dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<% Object ob=request.getAttribute("s"); %>
	
	<%Student s=(Student)ob; %>
	
	<h1>Data Update Form</h1>

	<form action="updateservlet" method="get">
		<input type="number" name="sid" placeholder="ID" value="<%=s.getId()%>"><br> <br>
		<input type="text" name="sname" placeholder="NAME" value="<%=s.getName() %>"><br> <br>
		<input type="email" name="semail" placeholder="EMAIL" value="<%=s.getEmail() %>"><br><br> 
		<input type="password" name="spassword" placeholder="PASSWORD" value="<%=s.getPassword() %>"><br> <br> 
		<input type="number" name="smark" placeholder="MARKS" value="<%=s.getPassword() %>"><br> <br>

		<button type="submit">Update</button>

	</form>

</body>
</html>