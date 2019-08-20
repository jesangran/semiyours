package deal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deal.model.service.DealService;
import deal.model.vo.Category1;
import deal.model.vo.Deal;
import deal.model.vo.DealAttachment;
import deal.model.vo.Local;
import member.model.vo.Member;

@WebServlet("/select.de")
public class SelectDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectDealServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 서비스 객체 생성
		DealService dService = new DealService();
		int start = 1;
		int limit = 24;

		String local ="";	
		Member loginUser=((Member)request.getSession().getAttribute("loginUser"));
			if( loginUser!=null ) { //로그인 했을 떄
				
				if(loginUser.getAddress1()!=null) {
					local =loginUser.getAddress1();
					local = local.split(" ")[0]+" "+local.split(" ")[1];
				}
			}
		
		 
		ArrayList<Deal> dList = dService.selectList(start, limit,local);
		ArrayList<DealAttachment> dfList = dService.selectDFList(start, limit,local);
		//ArrayList<Local> lList = dService.selectLocal();
		//ArrayList<Category1> c1List = dService.selectCategory1();
	
		String page = "";
	
		

	
		if (dList != null) {
			page = "index.jsp";
			request.setAttribute("dList", dList);
			request.setAttribute("dfList", dfList);
			//request.setAttribute("lList", lList);
			//request.setAttribute("cate1List", c1List);
	
			request.setAttribute("myLocal", local);
				
			
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 목록 조회 실패");
		}
		request.getRequestDispatcher(page).forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
