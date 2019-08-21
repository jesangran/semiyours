package mypage.controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deal.model.vo.Deal;
import deal.model.vo.DealAttachment;
import member.model.vo.Member;
import mypage.model.service.MypageService;

@WebServlet("/selectPick.my")
public class SelectPickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectPickServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uno = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		int start =1;
		int limit =8;
		MypageService myService = new MypageService();
		ArrayList<Deal> pList =  myService.selectPick(start,limit,uno);
		ArrayList<DealAttachment> pfList =myService.selectPickFile(start,limit,uno);
		String page = "";
		RequestDispatcher view = null;
		if(pList!=null && pfList!=null) {
			page="views/mypage/myPickView.jsp";
			request.setAttribute("pList", pList);
			request.setAttribute("pfList", pfList);
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("errorMsg","찜 내역을 조회하지 못했습니다.");
		}
		view= request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
