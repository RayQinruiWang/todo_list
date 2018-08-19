package webapp.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SignUpService{
	public boolean usernotExist() {
		// judge if username is available here, current just return true and let db reject existing username
		return true;
	}
	
	public void addUser(String username, String password) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do_users?useSSL=false","root","admin");
			PreparedStatement myStmt = myConn.prepareStatement("insert into users (username, password) values(?,?);");
			myStmt.setString(1, username);
			myStmt.setString(2, password);
			
			myStmt.executeUpdate();
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		}
	}
