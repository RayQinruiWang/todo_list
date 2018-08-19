package webapp.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

	public Boolean exist(Todo newtodo) {
		//Doesn't exist by default, let db reject
		return false;
	}
	
}
