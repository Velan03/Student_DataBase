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


@WebServlet("/login-in-form")
public class LoginSigninForm extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("semail");
		String pass=req.getParameter("spassword");
		
		StudentDAO dao=new StudentDAO();
		
		Student s=dao.fetchByEmail(email);
		
		if (s!=null) {
			if (s.getPassword().equals(pass)) {
				
				System.out.println("Login Successfull");
				
				req.setAttribute("msg", "Login Successfull");
				
				RequestDispatcher dispatcher= req.getRequestDispatcher("viewservlet");
				dispatcher.forward(req, resp);
				
			} else {
				System.out.println("Incorrect password");
				
				req.setAttribute("msg", "Incorrect password");
				
				RequestDispatcher dispatcher= req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			}
			
			
		} else {
			System.out.println("Email not found");
			
			req.setAttribute("msg", "Email Not Found");
			
			RequestDispatcher dispatcher= req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	
	
	}
	
	
}
