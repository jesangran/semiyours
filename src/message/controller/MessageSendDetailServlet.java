package message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.model.service.MessageService;
import message.model.vo.Message;

@WebServlet("/senddetailmsg.me")
public class MessageSendDetailServlet extends HttpServlet {
	/**
	 * 쪽지리스트 출력부 클릭시 쪽지창 뜨면서 상세보기 발신함
	 */
	private static final long serialVersionUID = 1L;
       
    public MessageSendDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mno = Integer.parseInt(request.getParameter("mno"));
		MessageService mService = new MessageService();
		//쪽지 조회
		Message msg = mService.SendselectMsg(mno);
		System.out.println("[msg] : " + msg);
		String page = "";
		if (msg != null) { 
			page = "views/message/sendMessageDetail.jsp";
			request.setAttribute("msg", msg);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "쪽지 상세조회 실패");
		}
	
		request.getRequestDispatcher(page).forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
