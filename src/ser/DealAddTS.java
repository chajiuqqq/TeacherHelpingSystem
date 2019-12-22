package ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TSDAO;

public class DealAddTS extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		int tid=Integer.parseInt(req.getParameter("tid"));
		int sid=Integer.parseInt(req.getParameter("sid"));
		int timeid=Integer.parseInt(req.getParameter("timeid"));
		int placeid=Integer.parseInt(req.getParameter("placeid"));
		
		TSDAO.addTS(tid, sid, timeid, placeid);
		
	}
}
