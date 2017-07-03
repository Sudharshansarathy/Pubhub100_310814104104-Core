package com.bookapp.dao;

import java.sql.Connection;

	import com.bookapp.model.User;
	import com.bookapp.util.ConnectionUtil;


	public class UserDAO {

		public void register(User user) throws Exception {

			Connection connection = ConnectionUtil.getConnection();

			String query = "INSERT INTO users(name,email_id,password) VALUES(?,?,?);";

			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());

			pst.executeUpdate();

		}
		

		
	    public void activateUser(User user) throws Exception{
	    	
	Connection connection = ConnectionUtil.getConnection();
			
			String query = "UPDATE users SET active = ? WHERE email_id =? AND password = ?;";
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1,user.getActive());
			pst.setString(2,user.getEmail());
			pst.setString(3,user.getPassword());
			pst.executeUpdate();
	    	
	    }
	    
	    
		public void changeUserName(User user,String newname)throws Exception{
			Connection connection = ConnectionUtil.getConnection();
			
			String query = "UPDATE users SET name = ? WHERE email_id =? AND password = ?;";
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,newname);
			pst.setString(2,user.getEmail());
			pst.setString(3,user.getPassword());
			pst.executeUpdate();
			
		}
		public void login(User user) throws Exception {
			Connection connection = ConnectionUtil.getConnection();

			String query = "SELECT * FROM users WHERE email_id=? AND password =?;";

			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
	        
			java.sql.ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("password"));
				
			}
			
		}

	}


