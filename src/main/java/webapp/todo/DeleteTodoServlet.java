package webapp.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.todo.TodoService;

@WebServlet(urlPatterns = "/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {

	private TodoService todoservice = new TodoService();
	/**
	 * 
	 */
	private static final long serialVersionUID = -7121242424128655492L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String owner = (String)request.getSession().getAttribute("name");
		todoservice.deleteTodo(new Todo(request.getParameter("todo"),request.getParameter("category"),owner));
		response.sendRedirect("/list_todo.do");
	}
	
}
