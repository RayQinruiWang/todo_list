package webapp.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.todo.TodoService;

// This is the URL for the todo servlet
@WebServlet(urlPatterns = "/list_todo.do")
public class ShowTodoServlet extends HttpServlet {

	private TodoService todoservice = new TodoService();
	/**
	 * 
	 */
	private static final long serialVersionUID = -7121242424128655492L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getSession().setAttribute("todo_description_and_categories", todoservice.retrieveTodosDescriptionAndCategory());
		request.getRequestDispatcher("/WEB-INF/views/todo_list.jsp").forward(request, response);
	}
	
}
