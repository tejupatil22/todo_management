package com.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    private static final String URL = "jdbc:mysql://localhost:3306/todo_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void main(String[] args) {

        Connection con = getConnection();

        if (con != null) {
            System.out.println("Connection Created");
        } else {
            System.out.println("Connection Failed");
        }
    }
}