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

@WebServlet("/editservlet")
public class EditServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDAO dao=new StudentDAO();
		
		Student s=dao.fetchById(id);
		
		req.setAttribute("s", s);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("update.jsp");
		dispatcher.forward(req, resp);
		
	}
}
