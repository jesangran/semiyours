package message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import message.model.service.MessageService;

@WebServlet("/countMsg.me")
public class MessageNewCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MessageNewCountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/* int count = Integer.parseInt(request.getParameter("count")); */
		int mowner = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		int count = new MessageService().newCountMsg(mowner);
		
		response.getWriter().print(count);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
