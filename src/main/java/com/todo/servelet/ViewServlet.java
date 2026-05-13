package com.todo.servelet;
import java.io.IOException;
import java.util.List;

import com.todo.dao.TaskDAO;
import com.todo.model.Task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewTask")

public class ViewServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		TaskDAO dao = new TaskDAO();
		List<Task> taskList = dao.getAllTask();
		
		request.setAttribute("taskList", taskList);
		request.getRequestDispatcher("dashboard.html").forward(request,response);
		
	}
}