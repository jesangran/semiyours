package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/deleteMember.me")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userno = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		int result = new MemberService().deleteMember(userno);
		
		if(result > 0) {
			HttpSession session = request.getSession(false);
			if(session != null) {
				session.removeAttribute("loginUser");
			}
			request.setAttribute("msg", "회원탈퇴가 완료되었습니다. 계정복구는 관리자에게 문의바랍니다.");
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("msg", "탈퇴할 수 없습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
