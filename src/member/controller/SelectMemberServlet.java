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
@WebServlet("/select.me")
public class SelectMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SelectMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uno = Integer.parseInt(request.getParameter("uno"));
		Member member = new MemberService().selectMember(uno);
		String page ="";
		RequestDispatcher view =null;
		if(member!=null) {
		
			request.getSession().setAttribute("member", member);
			request.getSession().setAttribute("mMsg","정보가 수정되었습니다.");
			response.sendRedirect("views/mypage/memberInfo.jsp");
	
		}else {
			page ="views/common/errorPage.jsp";
			request.setAttribute("errorMsg","정보 수정 중 오류가 발생했습니다!");
			view =request.getRequestDispatcher(page);
			view.forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
