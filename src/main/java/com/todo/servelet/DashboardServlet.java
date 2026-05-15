package com.todo.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import com.todo.dao.TaskDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/dashboard")

public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        TaskDAO dao = new TaskDAO();

        int total = dao.getTotalTasks();
        int completed = dao.getCompletedTasks();
        int pending = dao.getPendingTasks();
        int high = dao.getHighPriorityTasks();

        out.println("<h1>Dashboard Statistics</h1>");

        out.println("<h2>Total Tasks : " + total + "</h2>");
        out.println("<h2>Completed Tasks : " + completed + "</h2>");
        out.println("<h2>Pending Tasks : " + pending + "</h2>");
        out.println("<h2>High Priority Tasks : " + high + "</h2>");
    }
}