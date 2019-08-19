package message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deal.model.vo.Deal;
import member.model.vo.Member;
import message.model.service.MessageService;
import message.model.vo.Message;


@WebServlet("/insertMsg.me")
public class MessageInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MessageInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int mOwner = Integer.parseInt(request.getParameter("mOwner"));
		String mTitle = request.getParameter("mTitle");
		String mContent = request.getParameter("mContent");
		int mSender = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();  //로그인유저 보내는사람

		System.out.println("센더"+mSender);
		System.out.println("오너"+mOwner);
		
		mContent = mContent.replaceAll("\n", "<br>");
	
		Message msg = new Message();
		msg.setmOwner(mOwner);
		msg.setmTitle(mTitle);
		msg.setmContent(mContent);
		msg.setmSender(mSender);
		
		int result = new MessageService().MessageInsert(msg);
		String page = "";
		
		if(msg !=null && result >0) {
			request.setAttribute("msg", "쪽지가 발송되었습니다.");
			page = "views/deal/DealDetailView.jsp";
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "쪽지발송에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(page).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
