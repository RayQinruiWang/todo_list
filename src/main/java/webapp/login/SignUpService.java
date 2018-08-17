package webapp.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SignUpService{
	public void addUser(String username, String password) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do_users?useSSL=false","root","admin");
			Statement myStmt = myConn.createStatement();
			String sql = "insert into users "
					+ "(username, password)"
					+ "values('" + username + "','" + password + "');";
			myStmt.executeUpdate(sql);
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		}
	}
