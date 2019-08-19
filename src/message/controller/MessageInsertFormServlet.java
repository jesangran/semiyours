package message.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deal.model.vo.Deal;
import member.model.vo.Member;
import message.model.service.MessageService;

@WebServlet("/insertMsgForm.me")
public class MessageInsertFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MessageInsertFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setCharacterEncoding("UTF-8");
			int mOwner = Integer.parseInt(request.getParameter("mOwner")); //수신
			
			
			System.out.println("오너"+mOwner);
		
			request.setAttribute("mOwner", mOwner);
			
			RequestDispatcher view = request.getRequestDispatcher("views/message/insertMessageForm.jsp");
			view.forward(request, response);
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
