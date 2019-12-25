package ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TeacherDAO;
import poj.Teacher;

public class DealLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		boolean result=false;
		String role="default";
		
		
		if("admin".equals(username) && "admin".equals(password)){
			role="admin";
			result=true;
			req.getSession().setAttribute("login_flag", "1");
		}else{
			Teacher teacher=TeacherDAO.getTeacherObj(username, password);
			if(teacher!=null){
				role="teacher";
				result=true;
				req.getSession().setAttribute("current_teacher", teacher);
				req.getSession().setAttribute("login_flag", "1");
			}
	
		}
		
				
		res.setContentType("text/html;charset=utf-8");
		String str="{\"result\":\""+result+"\",\"role\":\""+ role +"\"}";
		System.out.println(str);
		res.getWriter().print(str);
	}
}
