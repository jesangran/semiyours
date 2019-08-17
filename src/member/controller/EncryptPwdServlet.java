package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/encryptPwd.me" , name="EncryptPwdServlet")
public class EncryptPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EncryptPwdServlet() {
    	 
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String encPwd = request.getParameter("checkPwd");
		request.setAttribute("encPwd", encPwd);
	
		
		RequestDispatcher view=request.getRequestDispatcher("views/common/header.jsp");
		view.forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
