package ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MessageDAO;
import net.sf.json.JSONSerializer;

public class SubmitRequest extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		int tno=Integer.parseInt(req.getParameter("tno"));
		int current_ts=Integer.parseInt(req.getParameter("current_ts"));
		
		MessageDAO.addMessage(tno, current_ts);
	}
}
