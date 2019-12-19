package ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MessageDAO;
import DAO.TSDAO;
import poj.Message;
import poj.Teacher;

public class DealMessage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//{"message_id":message_id,"ans":ans}
		req.setCharacterEncoding("utf-8");
		String ans=req.getParameter("ans");
		int message_id=Integer.parseInt(req.getParameter("message_id"));
		Message message=MessageDAO.getMessage(message_id);
		
		Teacher current_teacher=((Teacher)req.getSession().getAttribute("current_teacher"));
		System.out.println(current_teacher.getName());
		
		
		if("true".equals(ans)){
			TSDAO.updateTS(message.getTs(),current_teacher);
		
		}
		MessageDAO.removeMessage(message_id);
	}
}
