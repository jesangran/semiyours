package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findPwd.me")
public class resetPwdFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public resetPwdFormServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println(email);
		String page="";
		RequestDispatcher view=null;
		if(email!=null) {
			request.setAttribute("email",email);
			page="views/member/resetPwdForm.jsp";
		}else {
			request.setAttribute("errorMsg","오류가 발생했습니다.");
			page="views/common/errorPage.jsp";
		}
		view=request.getRequestDispatcher(page);
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
