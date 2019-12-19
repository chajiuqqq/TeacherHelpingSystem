package ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TeacherDAO;
import poj.Teacher;

public class DealRegister extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String realname=req.getParameter("realname");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		int tno=Integer.parseInt(req.getParameter("tno"));
		
		Teacher teacher=new Teacher();
		teacher.setTno(tno);
		teacher.setName(realname);
		teacher.setUsername(username);
		teacher.setPassword(password);
		TeacherDAO.addTeacher(teacher);
		
	}
}
