package in.co.rays.ors.ctl;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.ors.util.ServletUtility;
/**
 * Front Functionality ctl. to perform session management operation
 * @author AYUSH
 *
 */

@WebFilter(urlPatterns = {  "/ctl/*","/doc/*", })
public class FrontController implements Filter {

	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null)
		{

			request.setAttribute("error11", "Your session has been expired please login again");
			
            String str = request.getRequestURI();
			
			request.setAttribute("uri", str);
//			session.setAttribute("uri", str);

			ServletUtility.forward(ORSView.LOGIN_VIEW, request, response);
			return;
		} else {
			chain.doFilter(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

	
	public void destroy() {

	}

}
