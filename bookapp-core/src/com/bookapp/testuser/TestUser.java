package com.bookapp.testuser;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.bookapp.model.User;

public class TestUser {
	public static void main(String args[]) {

		 User user = new User();
		
		 user.setId(1);
		 user.setName("Ronnie");
		 user.setEmail("ronnie@gmail.com");
		 user.setPassword("pumpingiron");
		 user.setActive(0);
		
		 System.out.println(user);

	
	}

}
