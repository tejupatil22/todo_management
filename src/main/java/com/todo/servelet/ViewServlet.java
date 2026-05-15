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

        List<Task> list = dao.getAllTask();

        out.println("<html>");

        out.println("<head>");

        out.println("<title>View Tasks</title>");

        // CSS
        out.println("<style>");

        out.println("body{");
        out.println("font-family:Arial;");
        out.println("margin:0;");
        out.println("padding:0;");
        out.println("background:linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.6)),url('https://images.unsplash.com/photo-1506784365847-bbad939e9335');");
        out.println("background-size:cover;");
        out.println("color:white;");
        out.println("}");

        out.println(".container{");
        out.println("width:90%;");
        out.println("margin:auto;");
        out.println("margin-top:50px;");
        out.println("background:rgba(255,255,255,0.12);");
        out.println("padding:30px;");
        out.println("border-radius:20px;");
        out.println("backdrop-filter:blur(10px);");
        out.println("}");

        out.println("h2{");
        out.println("text-align:center;");
        out.println("margin-bottom:20px;");
        out.println("}");

        out.println("table{");
        out.println("width:100%;");
        out.println("border-collapse:collapse;");
        out.println("background:rgba(255,255,255,0.1);");
        out.println("}");

        out.println("th,td{");
        out.println("padding:12px;");
        out.println("text-align:center;");
        out.println("border:1px solid rgba(255,255,255,0.3);");
        out.println("}");

        out.println("th{");
        out.println("background:rgba(0,0,0,0.5);");
        out.println("}");

        out.println(".btn{");
        out.println("padding:8px 15px;");
        out.println("border-radius:8px;");
        out.println("text-decoration:none;");
        out.println("font-weight:bold;");
        out.println("margin:3px;");
        out.println("display:inline-block;");
        out.println("}");

        out.println(".update{");
        out.println("background:blue;");
        out.println("color:white;");
        out.println("}");

        out.println(".delete{");
        out.println("background:red;");
        out.println("color:white;");
        out.println("}");

        out.println(".back{");
        out.println("background:#00f2fe;");
        out.println("color:black;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");

        out.println("<h2>All Tasks</h2>");

        out.println("<a href='dashboard.html' class='btn back'>Back</a>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Title</th>");
        out.println("<th>Description</th>");
        out.println("<th>Deadline</th>");
        out.println("<th>Priority</th>");
        out.println("<th>Status</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");

        for(Task t : list) {

            out.println("<tr>");

            out.println("<td>" + t.getTaskId() + "</td>");
            out.println("<td>" + t.getTaskTitle() + "</td>");
            out.println("<td>" + t.getDescription() + "</td>");
            out.println("<td>" + t.getDeadline() + "</td>");
            out.println("<td>" + t.getPriority() + "</td>");
            out.println("<td>" + t.getStatus() + "</td>");

            out.println("<td>");

            out.println("<a href='updateTask?taskId="
                    + t.getTaskId()
                    + "' class='btn update'>Update</a>");

            out.println("<a href='deleteTask?taskId="
                    + t.getTaskId()
                    + "' class='btn delete'>Delete</a>");

            out.println("</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}