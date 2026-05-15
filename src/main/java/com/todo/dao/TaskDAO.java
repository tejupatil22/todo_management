package com.todo.dao;

import com.todo.model.Task;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class TaskDAO{
	
	public boolean addTask(Task t) {

	    boolean status = false;

	    try {

	        Connection con = DBconnection.getConnection();

	        String query =
	        "INSERT INTO task(task_title, description, deadline, priority, status) VALUES(?,?,?,?,?)";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setString(1, t.getTaskTitle());
	        ps.setString(2, t.getDescription());
	        ps.setString(3, t.getDeadline());
	        ps.setString(4, t.getPriority());
	        ps.setString(5, t.getStatus());

	        int row = ps.executeUpdate();

	        if(row > 0) {
	            status = true;
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
	
	
	public List<Task> getAllTask(){
		
		List <Task>list = new ArrayList<>();
		
		try {
			
			Connection con = DBconnection.getConnection();
			
			String query ="SELECT *from task";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Task t = new Task();
				
				t.setTaskId(rs.getInt("task_id"));
				t.setTaskTitle(rs.getString("task_title"));
				t.setDescription(rs.getString("description"));
				t.setDeadline(rs.getString("deadline"));
				t.setPriority(rs.getString("priority"));
				t.setStatus(rs.getString("status"));
				
				list.add(t);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean updateTask(Task t) {

	    boolean status = false;

	    try {

	        Connection con = DBconnection.getConnection();

	        String query =
	        "UPDATE task SET task_title=?, description=?, deadline=?, priority=?, status=? WHERE task_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setString(1, t.getTaskTitle());
	        ps.setString(2, t.getDescription());
	        ps.setString(3, t.getDeadline());
	        ps.setString(4, t.getPriority());
	        ps.setString(5, t.getStatus());
	        ps.setInt(6, t.getTaskId());

	        int row = ps.executeUpdate();

	        if(row > 0) {
	            status = true;
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
	
	public boolean deleteTask(int id) {

        boolean status = false;

        try {
            Connection con = DBconnection.getConnection();

            String query = "DELETE FROM task WHERE task_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int row = ps.executeUpdate();

            if (row > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
	
}


