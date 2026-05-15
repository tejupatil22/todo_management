package com.todo.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.todo.dao.TaskDAO;
import com.todo.model.Task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/viewTask")
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        TaskDAO dao = new TaskDAO();

        String keyword = request.getParameter("keyword");

        List<Task> list;

        if (keyword == null || keyword.trim().isEmpty()) {
            list = dao.getAllTask();
        } else {
            list = dao.searchTask(keyword);
        }

        out.println("<html><head><title>View Tasks</title>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.6)),url('https://images.unsplash.com/photo-1506784365847-bbad939e9335');background-size:cover;color:white;}");
        out.println(".container{width:90%;margin:auto;margin-top:50px;background:rgba(255,255,255,0.12);padding:30px;border-radius:20px;backdrop-filter:blur(10px);}");
        out.println("table{width:100%;border-collapse:collapse;}");
        out.println("th,td{padding:12px;border:1px solid white;text-align:center;}");
        out.println("th{background:rgba(0,0,0,0.5);}");
        out.println(".btn{padding:8px 12px;border-radius:6px;text-decoration:none;font-weight:bold;}");
        out.println(".update{background:blue;color:white;}");
        out.println(".delete{background:red;color:white;}");
        out.println(".back{background:#00f2fe;color:black;}");
        out.println("</style>");

        out.println("</head><body>");

        out.println("<div class='container'>");

        out.println("<h2 style='text-align:center;'>All Tasks</h2>");

        // SEARCH BAR
        out.println("<form method='get' action='viewTask' style='text-align:center;margin-bottom:15px;'>");
        out.println("<input type='text' name='keyword' placeholder='Search by ID or Name' style='padding:10px;width:250px;border-radius:8px;border:none;'>");
        out.println("<button type='submit' class='btn back' style='margin-left:10px;'>Search</button>");
        out.println("</form>");

        out.println("<a href='dashboard.html' class='btn back'>Back</a><br><br>");

        out.println("<table>");
        out.println("<tr><th>Sr No</th><th>Title</th><th>Description</th><th>Deadline</th><th>Priority</th><th>Status</th><th>Action</th></tr>");

        int sr = 1;

        for(Task t : list){

            out.println("<tr>");

            // SR NO FIXED
            out.println("<td>" + sr++ + "</td>");

            out.println("<td>"+t.getTaskTitle()+"</td>");
            out.println("<td>"+t.getDescription()+"</td>");
            out.println("<td>"+t.getDeadline()+"</td>");
            out.println("<td>"+t.getPriority()+"</td>");
            out.println("<td>"+t.getStatus()+"</td>");

            out.println("<td>");
            out.println("<a class='btn update' href='updateTask?taskId="+t.getTaskId()+"'>Update</a>");
            out.println("<a class='btn delete' href='deleteTask?taskId="+t.getTaskId()+"'>Delete</a>");
            out.println("</td>");

            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</div></body></html>");
    }
}