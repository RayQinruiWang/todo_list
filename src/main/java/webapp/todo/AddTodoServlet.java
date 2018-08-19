package webapp.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.todo.TodoService;

@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet {

	private TodoService todoservice = new TodoService();
	/**
	 * 
	 */
	private static final long serialVersionUID = -7121242424128655492L;

	@Override

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.getRequestDispatcher("/WEB-INF/views/add_todo.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String description = request.getParameter("todo");
		String category = request.getParameter("category");
		String owner = (String) request.getSession().getAttribute("name");
		Todo newtodo = new Todo(description,category,owner);
	
		Boolean todoexist = todoservice.exist(newtodo);
		
		if (todoexist) {
			System.out.println("We're here, todo exist");
			response.sendRedirect("/add-todo.do");
		}
		else{
			todoservice.addTodo(newtodo);
			response.sendRedirect("/list_todo.do");
		}
	}
	

}
