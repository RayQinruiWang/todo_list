package webapp.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();

	public List<Todo> retrieveTodosDescriptionAndCategory(String owner){
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do_users?useSSL=false","root","admin");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from todos where owner = '" + owner +"'");
			todos.clear();
			while (myRs.next()) {
				todos.add(new Todo(myRs.getString("description"),
									myRs.getString("category"),
									myRs.getString("owner")));
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		return todos;
	}

	public void addTodo(Todo todo) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do_users?useSSL=false","root","admin");
			Statement myStmt = myConn.createStatement();
			String sql = "insert into todos "
					+ "(description, category, owner)"
					+ "values('" + todo.getDescription() + "','" + todo.getCategory() + "','" + todo.getOwner() +"');";
			myStmt.executeUpdate(sql);
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

	public void deleteTodo(Todo todo) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do_users?useSSL=false","root","admin");
			Statement myStmt = myConn.createStatement();
			String sql = "delete from todos where description = '" + todo.getDescription() 
						+"' AND category = '" + todo.getCategory() 
						+"' AND owner = '" +todo.getOwner() +"';";
			myStmt.executeUpdate(sql);
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

	public Boolean todoExist(Todo newtodo) {
		ResultSet result = null;
		Connection myConn;
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do_users?useSSL=false","root","admin");
			PreparedStatement myStmt = myConn.prepareStatement("select * from todos where description = ? AND category = ? AND owner = ?");
			myStmt.setString(1, newtodo.getDescription());
			myStmt.setString(2, newtodo.getCategory());
			myStmt.setString(3, newtodo.getOwner());
			result = myStmt.executeQuery();
			if (result.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
