package webapp.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.todo.TodoService;

// This is the URL for the todo servlet
@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet {

	private TodoService todoservice = new TodoService();
	/**
	 * 
	 */
	private static final long serialVersionUID = -7121242424128655492L;

	@Override

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.getRequestDispatcher("/WEB-INF/views/new_todo.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String newTodo = request.getParameter("todo");
		String category = request.getParameter("category");
		String owner = (String) request.getSession().getAttribute("name");
		// has to implement into todo-service to check if the new todo exist
		Boolean isTodoExist = false;
		
		// If exist, create warning and go back to 
		if (isTodoExist) {
			// Here goes the code if the to-do to be created exist
			request.setAttribute("existingtodoerror", "This to-do exist, please try again");
			response.sendRedirect("/add_todo.do");
		}
		
		else{
			todoservice.addTodo(new Todo(newTodo, category, owner));
			response.sendRedirect("/list_todo.do");
		}
	}
	

}
