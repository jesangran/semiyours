package customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.model.service.NoticeService;
import customer.model.vo.NoticeVo;

@WebServlet("/noticeDetail.no")
public class noticeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public noticeDetail() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("db전");
		int nNo = Integer.parseInt(request.getParameter("nNo"));
		System.out.println("db후");
		NoticeVo nDetail = new NoticeService().noticeDetail(nNo);
		System.out.println(nDetail);
		RequestDispatcher view = null;
		
		String page = "";
		if (nDetail != null) { // 해당 글이 존재하는 경우
			page = "views/customer/notice/noticeDetail.jsp";
			request.setAttribute("nDetail", nDetail);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 상세 조회 중 에러 발생");
		}

		view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
