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
import message.model.vo.PageInfo;

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
		MessageService mService = new MessageService();
		int msender = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		System.out.println("msender"+msender);
		int msgCount = mService.sendMsgCount(msender); //발신 쪽지 갯수 조회하기
		System.out.println("msgCount"+msgCount);
		
		int limit = 5;
		int pagingBarSize = 5;
		int currentPage = 0;
		int maxPage = 0; 
		int startPage = 0;
		int endPage = 0;
		
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		maxPage =(int)Math.ceil((double)msgCount/limit);
		startPage = ((currentPage - 1) / limit) * pagingBarSize + 1;
		endPage = startPage + pagingBarSize - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pInf = new PageInfo(msgCount, limit, pagingBarSize, currentPage, maxPage, startPage, endPage);
		ArrayList<Message> mList = mService.sendList(currentPage, limit, msender);
				
		String page = "";
		
		if(mList != null) {
			page = "views/message/sendMsgBox.jsp";
			request.setAttribute("mList", mList);
			request.setAttribute("pInf", pInf);
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
