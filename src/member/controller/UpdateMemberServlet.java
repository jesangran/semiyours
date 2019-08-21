package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/update.me")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int userNo = Integer.parseInt(request.getParameter("uno"));
		System.out.println(userNo);
		String address1 = request.getParameter("addr");
			String address2=request.getParameter("addrDetail");
		String snsId = request.getParameter("snsId");
		Member member = new Member(userNo,address1,address2,snsId);
		int result = new MemberService().updateMember(member);
		String page = "";
		RequestDispatcher view= null;
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/select.me?uno="+userNo);

		}
		else {
			
			page = "views/common/errorPage.jsp";
		
			request.setAttribute("errorMsg", "수정과정에서 오류가 발생했습니다!");
			view=request.getRequestDispatcher(page);
			view.forward(request, response);
		}
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
