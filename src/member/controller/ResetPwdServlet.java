package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

@WebServlet(urlPatterns = "/resetPwd.me", name="ResetPwdServlet")
public class ResetPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResetPwdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("newPwd1");
		int result = new MemberService().updatePwd(email,pwd);
		String page="";
		RequestDispatcher view=null;
		if(result>0) {
			page="select.de";
			request.setAttribute("msg", "비밀번호가 재설정 되었습니다.");
			view=request.getRequestDispatcher(page);
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("errorMsg", "오류가 발생하였습니다.");
			view=request.getRequestDispatcher(page);
			
		}
		view.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
