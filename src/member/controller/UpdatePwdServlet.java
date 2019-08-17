package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class UpdatePwdServlet
 */
@WebServlet(urlPatterns = "/updatePwd.me" , name ="UpdatePwdServlet")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uno = request.getParameter("uno");
		String pwd = request.getParameter("pwd");
		String newPwd = request.getParameter("newPwd1");
		int result = new MemberService().updatePwd(uno,pwd,newPwd);
		String page="";
				
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/select.me?uno="+uno);
		}else {
			page = "views/common/errorPage.jsp";
			
			request.setAttribute("errorMsg", "수정과정에서 오류가 발생했습니다!");
			RequestDispatcher view=request.getRequestDispatcher(page);
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
