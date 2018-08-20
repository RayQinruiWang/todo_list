package webapp.signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpService{
	public boolean userExist(String username) {
			ResultSet result = null;
			Connection myConn;
			try {
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do_users?useSSL=false","root","admin");
				Statement myStmt = myConn.createStatement();
				result = myStmt.executeQuery("select username from users where username = '" + username +"'");
				if (result.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
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
			System.out.println("Same user exist and you didn't catch it until db does!!!!!!");
		}
		}
	}
