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

@WebServlet(urlPatterns = "/login.me",name = "LoginMemberServlet")
public class LoginMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("loginEmail");
		String pwd = request.getParameter("loginPwd");
		System.out.println(pwd);
		
		Member loginUser = new MemberService().loginMember(email,pwd);
		
		if(loginUser!=null) {
			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(1800);
			session.setAttribute("loginUser", loginUser);
			
			response.sendRedirect(request.getContextPath());
			String str ="asd";
			System.out.println(str.length());
		}else {
			request.setAttribute("errorMsg","로그인 정보가 틀렸습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
