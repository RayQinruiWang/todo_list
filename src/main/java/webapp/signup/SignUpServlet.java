package webapp.signup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/signup.do")
public class SignUpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4259461696350463254L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		SignUpService signupservice = new SignUpService();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		System.out.println(signupservice.userExist(username));
	
				if (!signupservice.userExist(username)) {
					signupservice.addUser(username, password);
					request.getSession().setAttribute("username", username);
					response.sendRedirect("/list_todo.do");
				}
				else {
					request.setAttribute("Userexisterror", "Sorry, this username is not available, please try another one");
					request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
				}

	}

}
