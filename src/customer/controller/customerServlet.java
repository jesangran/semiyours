package customer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.model.service.FaqService;
import customer.model.service.NoticeService;
import customer.model.vo.FaqVo;
import customer.model.vo.NoticeVo;
import customer.model.vo.PageInfo;

@WebServlet("/customer_Go")
public class customerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public customerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = "";
		page = "views/customer/ServiceCenter.jsp";
		
		/*if(FaqList != null) { // 정상적으로 조회된경우
			if(nList != null) {
			page = "views/customer/ServiceCenter.jsp";
			request.setAttribute("FaqList", FaqList);
			request.setAttribute("nList", nList);
			}
			else { // 비정상 작동시
				request.setAttribute("msg", "공시사항 조회 중 문제가 발생하였습니다. 에러 신고를 부탁드립니다.");
			}
		}
		else { // 조회가 되지 않은 경우
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "FAQ 조회 중 문제 발생.");
		}*/
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
