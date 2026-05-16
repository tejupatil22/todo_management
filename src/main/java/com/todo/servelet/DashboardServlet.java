package com.todo.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.todo.dao.TaskDAO;
import com.todo.model.Task;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        TaskDAO dao = new TaskDAO();
        List<Task> list = dao.getAllTask();

        int total = list.size();

        int completed = 0;
        int pending = 0;
        int inProgress = 0;

        int highPriority = 0;
        int mediumPriority = 0;
        int lowPriority = 0;

        for (Task t : list) {

            // STATUS
            if ("Completed".equalsIgnoreCase(t.getStatus())) {
                completed++;
            } else if ("In Progress".equalsIgnoreCase(t.getStatus())) {
                inProgress++;
            } else {
                pending++;
            }

            // PRIORITY
            if ("High".equalsIgnoreCase(t.getPriority())) {
                highPriority++;
            } else if ("Medium".equalsIgnoreCase(t.getPriority())) {
                mediumPriority++;
            } else if ("Low".equalsIgnoreCase(t.getPriority())) {
                lowPriority++;
            }
        }

        String context = request.getContextPath();

        out.println("<html><head>");
        out.println("<title>Dashboard</title>");

        // ================= CSS START =================
        out.println("<style>");

        out.println("body{margin:0;padding:0;font-family:Arial;background:linear-gradient(rgba(0,0,0,0.75),rgba(0,0,0,0.75)),url('https://images.unsplash.com/photo-1506784365847-bbad939e9335');background-size:cover;color:white;}");

        /* NAVBAR */
        out.println(".navbar{display:flex;justify-content:space-between;align-items:center;padding:18px 50px;background:rgba(0,0,0,0.4);backdrop-filter:blur(10px);}");
        out.println(".navbar a{color:white;text-decoration:none;margin-left:20px;font-size:18px;transition:0.3s;}");
        out.println(".navbar a:hover{color:#00f2fe;}");
        out.println(".logo{font-size:28px;font-weight:bold;font-style:italic;}");

        /* CONTAINER */
        out.println(".container{width:85%;margin:80px auto;background:rgba(255,255,255,0.12);padding:30px;border-radius:20px;backdrop-filter:blur(10px);} ");

        out.println("h2{text-align:center;margin-bottom:20px;font-size:32px;}");

        /* TABLE */
        out.println("table{width:100%;border-collapse:collapse;margin-top:20px;}");
        out.println("th,td{padding:15px;text-align:center;border:1px solid rgba(255,255,255,0.3);font-size:18px;}");
        out.println("th{background:rgba(0,0,0,0.7);}");

        /* HOVER EFFECT */
        out.println("tr:hover{background:rgba(255,255,255,0.1);} ");

        out.println("</style>");
        // ================= CSS END =================

        out.println("</head><body>");

        // ================= NAVBAR =================
        out.println("<div class='navbar'>");
        out.println("<div class='logo'>Todo System</div>");
        out.println("<div>");
        out.println("<a href='" + context + "/index.html'>Home</a>");
        out.println("<a href='" + context + "/viewTask'>View Tasks</a>");
        out.println("<a href='" + context + "/logout'>Logout</a>");
        out.println("</div>");
        out.println("</div>");

        // ================= CONTENT =================
        out.println("<div class='container'>");

        out.println("<h2>Dashboard Statistics</h2>");

        out.println("<table>");

        out.println("<tr><th>Metric</th><th>Count</th></tr>");

        out.println("<tr><td>Total Tasks</td><td>" + total + "</td></tr>");
        out.println("<tr><td>Completed Tasks</td><td>" + completed + "</td></tr>");
        out.println("<tr><td>In Progress Tasks</td><td>" + inProgress + "</td></tr>");
        out.println("<tr><td>Pending Tasks</td><td>" + pending + "</td></tr>");
        out.println("<tr><td>High Priority Tasks</td><td>" + highPriority + "</td></tr>");
        out.println("<tr><td>Medium Priority Tasks</td><td>" + mediumPriority + "</td></tr>");
        out.println("<tr><td>Low Priority Tasks</td><td>" + lowPriority + "</td></tr>");

        out.println("</table>");

        out.println("</div>");

        out.println("</body></html>");
    }
}