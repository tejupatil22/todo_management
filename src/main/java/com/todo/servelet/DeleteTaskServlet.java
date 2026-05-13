package com.todo.servelet;

import java.io.IOException;

import com.todo.dao.TaskDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@webServlet("/DeleteTaskServlet")

public class DeleteTaskServlet extends HTTPServlet 
{
	protected void doGet(HTTPServletRequest, HTTPServletResponse) throws ServletException, IOException
	{
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		
		TaskDAO dao = new TaskDAO();
		boolean result = dao.deleteTask(taskId);
		if(result)
		{
			response.sendRedirect("dashboard.jsp");
		}
		else
		{
			response.getWriter().println("Task Delete Failed");
		}
	}
}