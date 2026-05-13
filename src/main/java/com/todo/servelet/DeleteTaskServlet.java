package com.todo.servelet;

import java.io.IOException;

import com.todo.dao.TaskDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteTaskServlet")

public class DeleteTaskServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int taskId =
                Integer.parseInt(request.getParameter("taskId"));

        TaskDAO dao = new TaskDAO();

        boolean result = dao.deleteTask(taskId);

        if(result) {

            response.sendRedirect("dashboard.html");

        } else {

            response.getWriter().println("Task Delete Failed");
        }
    }
}