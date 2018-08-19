package webapp.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AuthenticationService{
	public boolean isUserVaild(String username, String password) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do_users?useSSL=false","root","admin");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from users");
			while (myRs.next()) {
				if(username.equals(myRs.getObject("username")) &&
					password.equals(myRs.getObject("password"))) {
					return true;
				}
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		return false;
		
	}
}
