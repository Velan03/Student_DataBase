package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
@WebServlet("/deleteservlet")
public class DeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDAO dao=new StudentDAO();
		
		dao.deleteById(id);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("viewservlet");
		dispatcher.forward(req, resp);
		
	
	}
	
	
}
