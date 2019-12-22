package ser;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PlaceDAO;
import DAO.TeacherDAO;
import DAO.TimeDAO;
import net.sf.json.JSONSerializer;
import poj.Place;
import poj.Teacher;
import poj.Time;


public class GetAvailablePlace extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		int timeid=Integer.parseInt(req.getParameter("timeid"));
		Time time=TimeDAO.getTimeObj(timeid);
		
		List<Place> places=PlaceDAO.getAvailablePlace(time);
		
		Map<Integer, String> place_map=new HashMap<Integer, String>();
		for(Place p:places){
			place_map.put(p.getId(), p.getPosition());
		}
		String str=JSONSerializer.toJSON(place_map).toString();
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().print(str);
		
	}
}
