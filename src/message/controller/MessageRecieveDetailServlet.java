package message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import message.model.service.MessageService;
import message.model.vo.Message;

@WebServlet("/recievedetailmsg.me")
public class MessageRecieveDetailServlet extends HttpServlet {
	/**
	 * 쪽지리스트 출력부 클릭시 쪽지창 뜨면서 상세보기
	 * (수신)
	 */
	private static final long serialVersionUID = 1L;
       
    public MessageRecieveDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int  mowner = ((Member)request.getSession().getAttribute("loginUser")).getUserNo(); 
		int mno = Integer.parseInt(request.getParameter("mno"));
		
		MessageService mService = new MessageService();
		//수신쪽지 쪽지 조회
		Message msg = mService.RecieveselectMsg(mno, mowner);
		System.out.println("[msg] : " + msg);
		String page = "";
		
		if(msg != null) { //쪽지 읽음 성공시, 상태를 읽음처리하고 view연결 처리
			if( mService.changeCondition(mno) > 0) {
				page = "views/message/recieveMessageDetail.jsp";
				request.setAttribute("msg", msg);
			}else {
				page = "views/common/errorPage.jsp";
				request.setAttribute("msg", "쪽지읽음처리 실패");
			}
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "쪽지 상세조회 실패");
		} 
	
		request.getRequestDispatcher(page).forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
