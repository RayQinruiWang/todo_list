package webapp.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TodoService {
	//Hard coded for now, ideally should talk to a database
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
// Need to upgrade to database operation
	public void addTodo(Todo todo) {
		todos.add(todo);
	}
// Need to upgrade to database operation	
	public void deleteTodo(Todo todo) {
		todos.remove(todo);
	}
	
}
