package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dto.Student;

@WebServlet("/FetchSigninForm")
public class FetchSigninForm extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("sid"));
		String name=req.getParameter("sname");
		String email=req.getParameter("semail");
		String pass=req.getParameter("spassword");
		double mark=Double.parseDouble(req.getParameter("smark"));
		
		StudentDAO dao=new StudentDAO();
		
		Student s=new Student();
		
		s.setId(id);
		s.setName(name);
		s.setEmail(email);
		s.setPassword(pass);
		s.setMarks(mark);
		
		//dao.saveStudent(s);
		//dao.fetchById(s);
		
		resp.getWriter().print("<h1>"+s+"</h1>");
		resp.getWriter().println(s);
		
		System.out.println("Data Saved Successfully");
		resp.getWriter().println("Data Saved Successfully");
		
	
	
	}

}
