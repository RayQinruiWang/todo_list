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
		if(request.getSession().getAttribute("name") != null) {
			chain.doFilter(serveletRequest, serveletResponse);
		} else {
			request.getRequestDispatcher("?login.do").forward(serveletRequest, serveletResponse);
		}
//		Temporary report in the console
//		System.out.println(request.getRequestURI());
	}

	@Override
	public void destroy() {
		
	}

}
