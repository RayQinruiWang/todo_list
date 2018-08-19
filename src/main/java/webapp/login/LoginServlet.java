package webapp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// When someone get to localhost:8080, it's gonna be redirected here
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	
	private AuthenticationService authservice = new AuthenticationService();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6886933344657784107L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isUserVaild = authservice.isUserVaild(username, password);
		
		if(isUserVaild) {
			request.getSession().setAttribute("username", username);
			response.sendRedirect("/list_todo.do");
		}
		else {
			request.setAttribute("errorMessage", "Invaid Credentials, please try again");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}

}
