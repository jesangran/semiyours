package report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import report.model.service.ReportService;
import report.model.vo.Report;

@WebServlet("/reportInsert.bo")
public class ReportInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReportInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String reportType = request.getParameter("reportType");
		int no = Integer.parseInt(request.getParameter("no"));
		String reportReason = request.getParameter("reportReason");
		String reportCon = request.getParameter("reportCon");
		/*
		 * int reporter =
		 * ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		 */
		
		Report report = new Report();
		report.setReportType(reportType);
		report.setNo(no);
		report.setReportReason(reportReason);
		report.setReportCon(reportCon);
		/* report.setReporter(reporter+""); */
		
		int result = new ReportService().insertReport(report);
		String page = "";
		RequestDispatcher view =null;
		
		if(result>0) {
			request.setAttribute("msg","신고가 완료되었습니다.");
			response.sendRedirect("myReportList.bo");
			System.out.println(report);
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("errorMsg", "신고 도중 에러가 발생하였습니다.");
			view=request.getRequestDispatcher(page);
		}
		
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
