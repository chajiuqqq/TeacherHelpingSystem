package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req1=(HttpServletRequest)req;
		HttpServletResponse res1=(HttpServletResponse)res;
		String uri=req1.getRequestURI().toString();
		System.out.println(uri);
		
		String login_flag=(String)req1.getSession().getAttribute("login_flag");
		if(login_flag==null && !uri.equals("/course/login.jsp") && !uri.equals("/course/register.jsp")){
			req1.getSession().removeAttribute("login_flag");
			res1.sendRedirect("login.jsp");
		}
		
		chain.doFilter(req1, res1);
	}

}
