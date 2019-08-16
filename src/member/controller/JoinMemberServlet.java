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

@WebServlet(urlPatterns = "/join.me", name="JoinMemberServlet") 
public class JoinMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JoinMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd1");
		String nickName = request.getParameter("nickName");
		Member member = new Member(email, pwd, nickName);
		int result = new MemberService().joinMember(member);
		String page="";
		RequestDispatcher view =null;
		if(result>0) {
			page="index.jsp";
			request.setAttribute("msg", "회원가입이 완료되었습니다.");
			view=request.getRequestDispatcher(page);
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("errorMsg", "회원가입 도중 오류가 발생하였습니다.");
			view=request.getRequestDispatcher(page);
			
		}
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
