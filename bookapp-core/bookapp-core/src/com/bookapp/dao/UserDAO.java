package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bookapp.model.User;
	import com.bookapp.util.ConnectionUtil;


	public class UserDAO {

		public void register(User user) {

			Connection connection=null;
			PreparedStatement pst=null;
			try {
				connection = ConnectionUtil.getConnection();
				String query = "INSERT INTO users(name,email_id,password) VALUES(?,?,?);";
				 pst = connection.prepareStatement(query);
				pst.setString(1, user.getName());
				pst.setString(2, user.getEmail());
				pst.setString(3, user.getPassword());

				pst.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

			

		}
		

		
	    public void activateUser(User user) {
	    	
	Connection connection=null;
	PreparedStatement pst=null;
	try {
		connection = ConnectionUtil.getConnection();
		String query = "UPDATE users SET active = ? WHERE email_id =? AND password = ?;";
	 pst = connection.prepareStatement(query);
		pst.setInt(1,user.getActive());
		pst.setString(2,user.getEmail());
		pst.setString(3,user.getPassword());
		pst.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
			
	    	
	    }
	    
	    
		public void changeUserName(User user,String newname){

			
			
			
			Connection connection =null;
			PreparedStatement pst=null;
			
			try {
				
				connection = ConnectionUtil.getConnection();
				String query = "UPDATE users SET name = ? WHERE email_id =? AND password = ?;";
				pst = connection.prepareStatement(query);
				
				pst.setString(1,newname);
				pst.setString(2,user.getEmail());
				pst.setString(3,user.getPassword());
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
		public void login(User user)  {
			Connection connection=null;
			PreparedStatement pst=null;
			try {
				connection = ConnectionUtil.getConnection();
				String query = "SELECT * FROM users WHERE email_id=? AND password =?;";
			    pst = connection.prepareStatement(query);
			 
				pst.setString(1, user.getEmail());
				pst.setString(2, user.getPassword());
		        
				java.sql.ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("password"));
					
			}}
				catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			finally {
               try {
            	   connection.close();
            	   pst.close();
            	   }
               catch (Exception e) {
            	   e.printStackTrace();
               }
			}}}
			
		

	


