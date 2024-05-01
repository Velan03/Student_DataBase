package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dto.Student;

@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet{
	
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
		
		dao.updateStudent(s);
		
		resp.getWriter().println("<h1>"+s+"</h1>");
		
		System.out.println("Data Updated Successfully");
		resp.getWriter().println("Data Updated Successfully");
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("viewservlet");
		dispatcher.forward(req, resp);
	
	
	
	
	}

}
