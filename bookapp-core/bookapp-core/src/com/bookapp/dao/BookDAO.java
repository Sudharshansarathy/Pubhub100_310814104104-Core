package com.bookapp.dao;

import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import com.bookapp.model.Book;
import com.bookapp.model.User;
	import com.bookapp.util.ConnectionUtil;

	public class BookDAO {

		public boolean addBook(Book book) {
			boolean flag = false;
			
			Connection connection =null;
			PreparedStatement pst=null;
			
			try {
			 connection = ConnectionUtil.getConnection();
				
				String query = "INSERT INTO books(book_name,book_price,book_image) VALUES(?,?,?);";
			 pst = connection.prepareStatement(query);
				pst.setString(1, book.getBookname());
				pst.setFloat(2, book.getBookprice());
				pst.setString(3, book.getBookimage());
				pst.executeUpdate();
				flag = true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}

			return flag;
		}

		public boolean deleteBook(Book book) {
			boolean flag = false;
			
			Connection connection =null;
			PreparedStatement pst=null;
			
			try {
				 connection = ConnectionUtil.getConnection();
				String query = " DELETE FROM books WHERE book_id=?;";
				 pst = connection.prepareStatement(query);
				pst.setInt(1, book.getBookid());
				pst.executeUpdate();
				flag = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}

			return flag;

		}

		public Book bookInfo(Book book) {
			Book bookinfo = new Book();
			Connection connection =null;
			PreparedStatement pst=null;
			
			try {
		    connection = ConnectionUtil.getConnection();
			String query = "SELECT book_name,book_id,book_image,book_price FROM books WHERE book_id=?;";
			 pst = connection.prepareStatement(query);
			pst.setInt(1, book.getBookid());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				bookinfo.setBookid(rs.getInt("book_id"));
				bookinfo.setBookname(rs.getString("book_name"));
				bookinfo.setBookprice(rs.getInt("book_price"));
				bookinfo.setBookimage(rs.getString("book_image"));
			}} catch (Exception e) {

				e.printStackTrace();
		}return bookinfo;
			}

		public List<Book> findByName(String pattern) {
			ArrayList<Book> books = new ArrayList();
			
			Connection connection =null;
			PreparedStatement pst=null;
			try{
			
		 connection = ConnectionUtil.getConnection();
			String query = "SELECT book_id,book_name,book_image,book_price FROM books WHERE book_name LIKE ?;";
		  pst = connection.prepareStatement(query);
			pst.setString(1, "%" + pattern + "%");
			// pst.setFloat(2, price);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Book book1 = new Book();
				book1.setBookname(rs.getString("book_name"));
				book1.setBookid(rs.getInt("book_id"));
				book1.setBookimage(rs.getString("book_image"));
				book1.setBookprice(rs.getFloat("book_price"));


				books.add(book1);
			}} catch (Exception e) {
				e.printStackTrace();}
			return books;
		}

		public List<Book> findAllBooks() {
			ArrayList<Book> books = new ArrayList();
			
			Connection connection =null;
			PreparedStatement pst=null;
			try {
				
			
		 connection = ConnectionUtil.getConnection();
			String query = "SELECT book_id,book_name,book_image,book_price FROM books;";
		 pst = connection.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Book book1 = new Book();
				book1.setBookname(rs.getString("book_name"));
				book1.setBookid(rs.getInt("book_id"));
				book1.setBookimage(rs.getString("book_image"));
				book1.setBookprice(rs.getFloat("book_price"));
				books.add(book1);

			}} catch (Exception e) {
				e.printStackTrace();
			
		}return books;
			}
		public List<Book> findById(int book_id) {
			ArrayList<Book> books = new ArrayList();
			
			Connection connection =null;
			PreparedStatement pst=null;
			try {
		  connection = ConnectionUtil.getConnection();
			String query = "SELECT book_id,book_name,book_image,book_price FROM books WHERE books_id = ?;";
		 pst = connection.prepareStatement(query);
			pst.setInt(1,book_id );
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Book book1 = new Book();
				book1.setBookname(rs.getString("book_name"));
				book1.setBookid(rs.getInt("book_id"));
				book1.setBookimage(rs.getString("book_image"));
				book1.setBookprice(rs.getFloat("book_price"));
				books.add(book1);

			}} catch (Exception e)
			{			e.printStackTrace();
			}finally {
	        try {
	      	   connection.close();
	      	   pst.close();
	      	   }
	         catch (Exception e) {
	      	   e.printStackTrace();
	         } return books;
	 		}}
		
	}
		


