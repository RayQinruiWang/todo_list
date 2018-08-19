package webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "*.do")
public class LoginRequiredFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest serveletRequest, ServletResponse serveletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) serveletRequest;
		if(request.getSession().getAttribute("username") != null||
			request.getServletPath().equals("/signup.do")) {
			chain.doFilter(serveletRequest, serveletResponse);
		} else {
			request.getRequestDispatcher("?login.do").forward(serveletRequest, serveletResponse);
		}
	}

	@Override
	public void destroy() {
		
	}

}
