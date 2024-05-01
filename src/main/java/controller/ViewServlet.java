package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dto.Student;

@WebServlet("/viewservlet")
public class ViewServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDAO dao=new StudentDAO();
		
		List<Student> list = dao.getAllStudent();
		
		req.setAttribute("list", list);
	
		req.getRequestDispatcher("view.jsp").forward(req, resp);
	
	
	}

}
