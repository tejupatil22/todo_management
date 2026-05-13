package com.todo.servelet;

import java.io.IOException;

import com.todo.dao.TaskDAO;
import com.todo.model.Task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateTaskServlet")

public class UpdateTaskServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String deadline = request.getParameter("deadline");
		String priority = request.getParameter("priority");
		String status = request.getParameter("status");
		
		Task task = new Task();
		
		task.setTaskId(taskId);
		task.setTaskTitle(title);
		task.setDescription(description);
		task.setDeadline(deadline);
		task.setPriority(priority);
		task.setStatus(status);
		
		TaskDAO dao = new TaskDAO();
		boolean result=dao.updateTask(task);
		if(result)
		{
			response.sendRedirect("dashboard.jsp");
		}
		else
		{
			response.getWriter().println("Task Update Failes");
		}
		
	}
}