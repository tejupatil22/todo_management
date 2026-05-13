package com.todo.servelet;

import java.io.IOException;

import com.todo.dao.UserDAO;
import com.todo.model.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")

public class RegisterServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		user u = new user();
		
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		
		UserDAO dao = new UserDAO();
		
		boolean status = dao.registerUser(u);
		
		if(status) {
			response.sendRedirect("login.html");
		}else {
			response.sendRedirect(password);
		}
		
	}
		
	
}
