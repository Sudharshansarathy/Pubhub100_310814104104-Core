package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.model.Book;
import com.bookapp.model.User;
import com.bookapp.model.Order;
import com.bookapp.util.ConnectionUtil;

public class OrderDAO {
	public boolean addUserBook(int user_id,int book_id) {
		boolean flag = false;
		Connection connection =null;
		PreparedStatement pst=null;

		try{
			connection = ConnectionUtil.getConnection();
			String query = "INSERT INTO orders(user_id,book_id) VALUES(?,?);";
		 pst = connection.prepareStatement(query);
			pst.setInt(1,user_id);
			pst.setInt(2,book_id);
		pst.executeUpdate();
		flag = true;
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		return flag;
	}
	
	public boolean deleteUserBook(int user_id,int book_id) {
		boolean flag = false;
		
		Connection connection =null;
		PreparedStatement pst=null;
		
		
		try{
		 connection = ConnectionUtil.getConnection();
			String query = "DELETE FROM orders WHERE book_id = ? AND user_id = ?;";
			pst = connection.prepareStatement(query);
			pst.setInt(1,book_id);
			pst.setInt(2,user_id);
			pst.executeUpdate();
			flag = true;
			}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					flag = false;
				}
			return flag;
	}
public List<Integer> userBook(int user_id) {
	List<Integer> books = new ArrayList<Integer>();
	
	Connection connection =null;
	PreparedStatement pst=null;
	try {
     connection = ConnectionUtil.getConnection();
	String query ="SELECT book_id FROM orders WHERE user_id = ?;";
	 pst = connection.prepareStatement(query);
	pst.setInt(1,user_id);
	ResultSet rs = pst.executeQuery();
	while (rs.next()) {
		books.add(rs.getInt("book_id"));}}
	catch (Exception e)
	{ 
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
	
    return books;
} 
}	
}
