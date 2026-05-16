package com.todo.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.todo.dao.DBconnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/filter")
public class FilterTaskServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String status = request.getParameter("status");

        try {

            Connection con = DBconnection.getConnection();

            String sql =
            "SELECT * FROM task WHERE status=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, status);

            ResultSet rs = ps.executeQuery();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Filtered Tasks</title>");

            // CSS
            out.println("<style>");

            out.println("body{");
            out.println("font-family:Arial;");
            out.println("margin:0;");
            out.println("padding:0;");
            out.println("background:linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7)),url('https://images.unsplash.com/photo-1506784365847-bbad939e9335');");
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
            out.println("margin-bottom:30px;");
            out.println("}");

            out.println("table{");
            out.println("width:100%;");
            out.println("border-collapse:collapse;");
            out.println("}");

            out.println("th,td{");
            out.println("padding:14px;");
            out.println("text-align:center;");
            out.println("border:1px solid rgba(255,255,255,0.3);");
            out.println("}");

            out.println("th{");
            out.println("background:#00c853;");
            out.println("}");

            out.println(".btn{");
            out.println("padding:12px 20px;");
            out.println("text-decoration:none;");
            out.println("border-radius:8px;");
            out.println("font-weight:bold;");
            out.println("display:inline-block;");
            out.println("margin-top:20px;");
            out.println("margin-right:10px;");
            out.println("}");

            out.println(".back{");
            out.println("background:#00c853;");
            out.println("color:white;");
            out.println("}");

            out.println(".dashboard{");
            out.println("background:#ff5252;");
            out.println("color:white;");
            out.println("}");

            out.println("</style>");

            out.println("</head>");
            out.println("<body>");

            out.println("<div class='container'>");

            out.println("<h2>" + status + " Tasks</h2>");

            out.println("<table>");

            out.println("<tr>");
            out.println("<th>Sr No</th>");
            out.println("<th>Task Title</th>");
            out.println("<th>Description</th>");
            out.println("<th>Deadline</th>");
            out.println("<th>Priority</th>");
            out.println("<th>Status</th>");
            out.println("</tr>");

            int count = 1;

            while(rs.next()){

                out.println("<tr>");

                out.println("<td>" + count++ + "</td>");
                out.println("<td>" + rs.getString("task_title") + "</td>");
                out.println("<td>" + rs.getString("description") + "</td>");
                out.println("<td>" + rs.getString("deadline") + "</td>");
                out.println("<td>" + rs.getString("priority") + "</td>");
                out.println("<td>" + rs.getString("status") + "</td>");

                out.println("</tr>");
            }

            out.println("</table>");

            out.println("<br>");

            out.println("<a href='filter.html' class='btn back'>Back</a>");

            out.println("<a href='dashboard' class='btn dashboard'>Dashboard</a>");

            out.println("</div>");

            out.println("</body>");
            out.println("</html>");

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

            out.println("<h2>Error : " + e.getMessage() + "</h2>");
        }
    }
}