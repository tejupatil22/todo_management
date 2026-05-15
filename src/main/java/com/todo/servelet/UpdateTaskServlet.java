package com.todo.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.todo.dao.DBconnection;
import com.todo.dao.TaskDAO;
import com.todo.model.Task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/updateTask")

public class UpdateTaskServlet extends HttpServlet {

    // ================= SHOW UPDATE FORM =================
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int taskId =
                Integer.parseInt(request.getParameter("taskId"));

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            Connection con =
                    DBconnection.getConnection();

            String query =
                    "SELECT * FROM task WHERE task_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, taskId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                out.println("<html>");
                out.println("<head>");

                out.println("<title>Update Task</title>");

                out.println("<style>");

                out.println("body{");
                out.println("font-family:Arial;");
                out.println("background:#111;");
                out.println("color:white;");
                out.println("padding:40px;");
                out.println("}");

                out.println(".box{");
                out.println("width:500px;");
                out.println("margin:auto;");
                out.println("padding:30px;");
                out.println("background:rgba(255,255,255,0.1);");
                out.println("border-radius:15px;");
                out.println("}");

                out.println("input,select{");
                out.println("width:100%;");
                out.println("padding:10px;");
                out.println("margin:10px 0;");
                out.println("border:none;");
                out.println("border-radius:8px;");
                out.println("}");

                out.println("button{");
                out.println("padding:10px 20px;");
                out.println("background:blue;");
                out.println("color:white;");
                out.println("border:none;");
                out.println("border-radius:8px;");
                out.println("cursor:pointer;");
                out.println("}");

                out.println("</style>");

                out.println("</head>");
                out.println("<body>");

                out.println("<div class='box'>");

                out.println("<h2>Update Task</h2>");

                out.println("<form action='updateTask' method='post'>");

                out.println("<input type='hidden' name='taskId' value='"
                        + rs.getInt("task_id") + "'>");

                out.println("<input type='text' name='title' value='"
                        + rs.getString("task_title") + "'>");

                out.println("<input type='text' name='description' value='"
                        + rs.getString("description") + "'>");

                out.println("<input type='date' name='deadline' value='"
                        + rs.getString("deadline") + "'>");

                out.println("<input type='text' name='priority' value='"
                        + rs.getString("priority") + "'>");

                out.println("<input type='text' name='status' value='"
                        + rs.getString("status") + "'>");

                out.println("<button type='submit'>Update Task</button>");

                out.println("</form>");

                out.println("</div>");

                out.println("</body>");
                out.println("</html>");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // ================= UPDATE DATABASE =================
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int taskId =
                Integer.parseInt(request.getParameter("taskId"));

        String title =
                request.getParameter("title");

        String description =
                request.getParameter("description");

        String deadline =
                request.getParameter("deadline");

        String priority =
                request.getParameter("priority");

        String status =
                request.getParameter("status");

        Task task = new Task();

        task.setTaskId(taskId);
        task.setTaskTitle(title);
        task.setDescription(description);
        task.setDeadline(deadline);
        task.setPriority(priority);
        task.setStatus(status);

        TaskDAO dao = new TaskDAO();

        boolean result = dao.updateTask(task);

        if(result) {

            response.sendRedirect("viewTask");

        } else {

            response.getWriter().println("Task Update Failed");
        }
    }
}