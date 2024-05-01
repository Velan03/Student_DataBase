<%@page import="dao.StudentDAO"%>
<%@page import="dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	
	List<Student> list= (List<Student>)request.getAttribute("list");
	
	String msg = (String) request.getAttribute("msg");
	%>
	
	<h1><%= msg %></h1>
	
	<table border="2px">
		<tr>
			<td>Student ID</td>	
			<td>Student Name</td>	
			<td>Student Email</td>	
			<td>Student Password</td>	
			<td>Student Marks</td>	
			<td>Student Delete</td>	
			<td>Student Edit</td>	
		</tr>
		
		<%
		for(Student s:list){ 
		%>
		
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName() %></td>
			<td><%=s.getEmail() %></td>
			<td><%=s.getPassword() %></td>
			<td><%=s.getMarks() %></td>
			<td><a href="deleteservlet?id=<%=s.getId()%>">Delete this Data</a></td>
			<td><a href="editservlet?id=<%=s.getId()%>">Edit Student</a></td>
		</tr>
		
		<%
		}
		%>
		
	</table>
	


</body>
</html>