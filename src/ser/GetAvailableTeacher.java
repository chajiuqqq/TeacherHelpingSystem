package ser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.adminDAO;
import net.sf.json.JSONSerializer;
import poj.Teacher;
import poj.Simple_Teacher;



public class GetAvailableTeacher extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		int ts_id=Integer.parseInt(req.getParameter("TS_id"));
		List<Teacher> teachers=adminDAO.get_available_teacher(ts_id);
		
		List<Simple_Teacher> simple_Teachers=new ArrayList<Simple_Teacher>();
		
		
		for(Teacher t:teachers){
			simple_Teachers.add(new Simple_Teacher(t.getTno(),t.getName(), t.getUsername(),t.getPassword()));
		}
		
		
		
		
		String str_teachers=JSONSerializer.toJSON(simple_Teachers).toString();
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().print(str_teachers);
	}
}
