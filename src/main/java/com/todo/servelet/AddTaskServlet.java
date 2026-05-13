package com.todo.servelet;
import java.io.IOException;
import com.todo.model.Task;
import com.todo.dao.TaskDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Task t = new Task();

        t.setTaskTitle(request.getParameter("title"));
        t.setDescription(request.getParameter("description"));
        t.setDeadline(request.getParameter("deadline"));
        t.setPriority(request.getParameter("priority"));
        t.setStatus(request.getParameter("status"));

        TaskDAO dao = new TaskDAO();
        dao.addTask(t);

        response.sendRedirect("dashboard.html");
    }
}