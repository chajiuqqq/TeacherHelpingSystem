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
		String role="";
		
		if("admin".equals(username) && "admin".equals(password)){
			role="admin";
			result=true;
		}else{
			Teacher teacher=TeacherDAO.getTeacherObj(username, password);
			if(teacher!=null){
				role="teacher";
				result=true;
				req.getSession().setAttribute("current_teacher", teacher);
			}
	
		}
		
				
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().print("{\"result\":"+result+",\"role\":\""+ role +"\"}");
	}
}
