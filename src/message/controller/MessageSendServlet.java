package message.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import message.model.service.MessageService;
import message.model.vo.Message;

/**
 * 쪽지 발신 목록 조회
 */
@WebServlet("/sendmsg.me")
public class MessageSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MessageSendServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		ArrayList<Message> mList = new MessageService().sendList(userNo);
		
		String page = "";
		
		if(mList != null) {
			page = "views/message/sendMsgBox.jsp";
			request.setAttribute("mList", mList);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "쪽지 수신 목록 조회에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
