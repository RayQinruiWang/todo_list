package webapp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/signup.do")
public class SignUpServlet extends HttpServlet {
	private SignUpService signupservice = new SignUpService();


	/**
	 * 
	 */
	private static final long serialVersionUID = 4259461696350463254L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		if (signupservice.usernotExist()) {
			signupservice.addUser(username, password);
			request.getSession().setAttribute("name", username);
			response.sendRedirect("/list_todo.do");
		}
		else {
			response.sendRedirect("/signup.do");
		}
	}

}
