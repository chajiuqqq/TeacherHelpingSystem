package ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TeacherDAO;
import poj.Teacher;

public class UpdateTeacher extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		int tno=Integer.parseInt(req.getParameter("tno"));
		String name=req.getParameter("name");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		Teacher teacher=new Teacher();
		teacher.setTno(tno);
		teacher.setName(name);
		teacher.setUsername(username);
		teacher.setPassword(password);
		
		req.getSession().setAttribute("current_teacher",teacher);
		TeacherDAO.updateTeacher(teacher);
		
	}
}
