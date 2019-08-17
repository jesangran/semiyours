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
 * 쪽지 수신 목록 조회
 */
@WebServlet("/recievemsg.me")
public class MessageRecieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MessageRecieveServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		request.setCharacterEncoding("UTF-8");
		ArrayList<Message> mList = new MessageService().recieveList(userNo);
		
		String page = "";
		
		if(mList != null) {
			page = "views/message/recieveMsgBox.jsp";
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
