package message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.model.service.MessageService;

@WebServlet("/recieveDeleteMsg.me")
public class MessageRecieveDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MessageRecieveDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int mno = Integer.parseInt(request.getParameter("mno"));
		int result = new MessageService().recieveMsgDelete(mno);
		
		response.getWriter().print(result);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
