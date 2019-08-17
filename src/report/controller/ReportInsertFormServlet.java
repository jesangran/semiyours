package report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;

@WebServlet("/insertForm.re")
public class ReportInsertFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReportInsertFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		int rType = Integer.parseInt(request.getParameter("rType"));
		int reporter =((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		request.setAttribute("no", no);
		request.setAttribute("rType", rType);
		request.setAttribute("reporter", reporter);
		RequestDispatcher view = request.getRequestDispatcher("views/report/ReportInsertForm.jsp");
		view.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
