package ser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MessageDAO;
import DAO.TSDAO;
import net.sf.json.JSONSerializer;
import poj.Message;
import poj.Simple_t_s;
import poj.Teacher;
import poj.Teacher_Subject;

public class GetMessage extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Teacher teacher=(Teacher)req.getSession().getAttribute("current_teacher");
		Set<Message> messages=MessageDAO.get_this_teacher_message(teacher.getTno());
		List<Simple_t_s> tsList=new ArrayList<Simple_t_s>();
		
		for(Message m:messages){
			Teacher_Subject ts=m.getTs();
			tsList.add(new Simple_t_s(ts.getId(), ts.getTeacher().getName(), ts.getSubject().getName(), ts.getTime().getPeriod(), ts.getPlace().getPosition()));	
		}
		
		String str=JSONSerializer.toJSON(tsList).toString();
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().print(str);
	
	}
}
