package ser;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TeacherDAO;
import DAO.TimeDAO;
import net.sf.json.JSONSerializer;
import poj.Teacher;
import poj.Time;


public class GetAvailableTime extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		int tid=Integer.parseInt(req.getParameter("tid"));
		Teacher teacher=TeacherDAO.getTeacherObj(tid);
		List<Time> times=TimeDAO.getAvailableTime(teacher);
		Map<Integer, String> time_map=new HashMap<Integer, String>();
		for(Time t:times){
			time_map.put(t.getId(), t.getPeriod());
		}
		String str=JSONSerializer.toJSON(time_map).toString();
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().print(str);
		
	}
}
