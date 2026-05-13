package com.todo.servelet;

import java.io.IOException;
import com.todo.model.user;
import com.todo.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
		
	protected void doPost(HttpServletRequest request ,HttpServletResponse response ) throws ServletException , IOException{
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDAO dao = new UserDAO();
		
		user u = dao.loginUser(email, password);
		
		if(u!=null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("user", u);
			
			response.sendRedirect("dashboard.html");
		}else {
			response.sendRedirect("login.html");
		}
		
	}
}


