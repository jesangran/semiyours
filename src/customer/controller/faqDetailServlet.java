package customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.model.service.FaqService;
import customer.model.vo.FaqVo;

@WebServlet("/faqDetail.no")
public class faqDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public faqDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int fno = Integer.parseInt(request.getParameter("fno"));

		FaqVo detail = new FaqService().faqDetail(fno);
		System.out.println(detail);
		RequestDispatcher view = null;
		
		String page = "";
		if (detail != null) { // 해당 글이 존재하는 경우
			page = "views/customer/faq/FaqDetail.jsp";
			request.setAttribute("detail", detail);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "FAQ 상세 조회 중 에러 발생");
		}

		view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
