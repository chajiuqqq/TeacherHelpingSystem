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
		
		Teacher teacher=TeacherDAO.getTeacherObj(username, password);
		boolean result=(teacher==null)?false:true;
		if(result){
			req.getSession().setAttribute("current_teacher", teacher);
		}
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().print("{\"result\":"+result+"}");
	}
}
