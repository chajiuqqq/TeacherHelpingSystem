package ser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TeacherDAO;
import DAO.adminDAO;
import net.sf.json.JSONSerializer;
import poj.Simple_t_s;
import poj.Teacher;
import poj.Teacher_Subject;

public class Arrangement extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html;charset=utf-8");
		
		Teacher teacher=(Teacher)req.getSession().getAttribute("current_teacher");
		
		
		
		TeacherDAO teacherDAO=new TeacherDAO();
		List<Teacher_Subject> t_s_list=adminDAO.get_arrangement(teacher.getTno());
		
		List<Simple_t_s> simple_t_s_list=new ArrayList<Simple_t_s>();
		for(Teacher_Subject t_s:t_s_list){
			int id=t_s.getId();
			String atname=t_s.getTeacher().getName();
			String asname=t_s.getSubject().getName();
			String aperiod=t_s.getTime().getPeriod();
			String aposition=t_s.getPlace().getPosition();
			Simple_t_s simple_t_s=new Simple_t_s(id,atname, asname, aperiod, aposition);
			simple_t_s_list.add(simple_t_s);
		}
		
		String arragement=JSONSerializer.toJSON(simple_t_s_list).toString();
		System.out.println(arragement);
		res.getWriter().print(arragement);
	}
	
}
