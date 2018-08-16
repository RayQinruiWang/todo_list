package webapp.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
	//Hard coded for now, ideally should talk to a database
	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo("Add due date to todos","implementation"));
		todos.add(new Todo("Learn Java web","Learning"));
		todos.add(new Todo("Learn Oauth2","Learning"));
		todos.add(new Todo("Learn JDBC", "Learning"));
		todos.add(new Todo("Learn JavaScript and React", "Optional"));
	}
	
	public List<Todo> retrieveTodos(){
		return todos;
	}
	
	public void addTodo(Todo todo) {
		todos.add(todo);
	}
	
	public void deleteTodo(Todo todo) {
		todos.remove(todo);
	}
	
}
