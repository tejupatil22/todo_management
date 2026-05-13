package com.todo.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

import com.todo.model.user;

public class UserDAO{
//	Register DAo--
	public boolean registerUser(user user) {
		 boolean status = false;
		 
		 try {
			 
			 
			 Connection con = DBconnection.getConnection();
			 
			 String query = "Insert into user(name,email, password) VALUES (?,?,?)";
			 
			 PreparedStatement ps = con.prepareStatement(query);
			 
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			
			
			int row = ps.executeUpdate();
			
			if(row>0) {
				
				status = true;
			}
			
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return status;
	}
	
//	USER DAO
	
	public user loginUser(String email ,  String password){
		
		user user = null;
		
		
		try {
			
			Connection con = DBconnection.getConnection();
			
			String query = "SELECT * FROM user where email =? AND password=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
		 ps.setString(1, email);
		 ps.setString(2, password);
		 
		 ResultSet rs = ps.executeQuery();
		 
		 if(rs.next()) {
			 
			 user = new user();
			 
			 user.setUserId(rs.getInt("user_id"));
			user.setName(rs.getString("user_name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
		 }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
}

