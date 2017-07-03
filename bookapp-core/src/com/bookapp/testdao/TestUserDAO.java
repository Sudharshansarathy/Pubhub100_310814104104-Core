package com.bookapp.testdao;


	import com.bookapp.dao.UserDAO;
	import com.bookapp.model.User;

	public class TestUserDAO {
		public static void main(String[] args) throws Exception {
			User user = new User();
			user.setEmail("ronnie@gmail.com");
			user.setPassword("pumpingiron");
			
			
			UserDAO userdao = new UserDAO();
			userdao.activateUser(user);
		}

	}


