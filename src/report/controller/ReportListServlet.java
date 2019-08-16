package report.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import report.model.service.ReportService;
import report.model.vo.PageInfo;
import report.model.vo.Report;

@WebServlet("/myReportList.bo")
public class ReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReportListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReportService rService = new ReportService();
		
		//페이징처리
		int reportCount = rService.getReportCount();
		
		int limit = 5;             // 한 페이지에 보여질 게시글 수 
		int pagingBarSize = 5;     // 보여질 페이징바의 페이지 개수
		int currentPage = 0;        // 페이지 번호를 표시할 변수
		int maxPage = 0;            // 전체 페이지에서 가장 마지막 페이지 
		int startPage = 0;          // 페이징바 시작페이지 번호 
		int endPage = 0;            // 페이징바 끝 페이지 번호 \
		
		if(request.getParameter("currentPage") == null){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		maxPage = (int)Math.ceil((double)reportCount/limit);
		startPage = ((currentPage-1)/limit) * pagingBarSize +1 ;
		
		if(maxPage <= endPage) {endPage = maxPage;}
		
		PageInfo pInf = new PageInfo(reportCount, limit, pagingBarSize, currentPage, maxPage, startPage, endPage);
		
		//게시물조회
		ArrayList<Report> rList = rService.selectList(currentPage,limit);
		
		String page = "";
		
		if(rList != null) {
			page = "views/mypage/myReportList.jsp";
			request.setAttribute("rList", rList);
			request.setAttribute("pInf", pInf);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "신고 목록 조회 실패");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
