package com.todo.servelet;
import java.io.IOException;
import java.io.PrintWriter;

import com.todo.model.Task;
import com.todo.dao.TaskDAO;
import jakarta.servlet.*;

import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;



@WebServlet("/searchTask")
public class SearchTaskServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        String keyword = request.getParameter("keyword");

        TaskDAO dao = new TaskDAO();
        List<Task> list = dao.searchTask(keyword);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");

        out.println("<title>Search Results</title>");

  
        out.println("<style>");
        out.println("body{font-family:Arial;background:#222;color:white;text-align:center;}");
        out.println("table{width:90%;margin:auto;margin-top:20px;border-collapse:collapse;}");
        out.println("th,td{padding:10px;border:1px solid white;}");
        out.println("th{background:black;}");
        out.println(".btn{padding:5px 10px;text-decoration:none;border-radius:5px;}");
        out.println(".back{background:orange;color:black;}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Search Task</h2>");

        // BACK BUTTON
        out.println("<a class='btn back' href='dashboard.html'>Back</a>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Title</th>");
        out.println("<th>Description</th>");
        out.println("<th>Deadline</th>");
        out.println("<th>Priority</th>");
        out.println("<th>Status</th>");
        out.println("</tr>");

        if(list.isEmpty()){
            out.println("<tr><td colspan='6'>No Task Found</td></tr>");
        } else {

            for(Task t : list){

                out.println("<tr>");
                out.println("<td>" + t.getTaskId() + "</td>");
                out.println("<td>" + t.getTaskTitle() + "</td>");
                out.println("<td>" + t.getDescription() + "</td>");
                out.println("<td>" + t.getDeadline() + "</td>");
                out.println("<td>" + t.getPriority() + "</td>");
                out.println("<td>" + t.getStatus() + "</td>");
                out.println("</tr>");
            }
        }

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
       
    }
}