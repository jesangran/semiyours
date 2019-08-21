package deal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import deal.model.service.DealService;
import deal.model.vo.Deal;
import deal.model.vo.DealAttachment;
import member.model.vo.Member;

@WebServlet("/search.de")
public class DealSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DealSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start =1;
		int limit=24;
		String cName = request.getParameter("cName");
		String keyword = request.getParameter("keyword");
		String local = ((Member)request.getSession().getAttribute("loginUser")).getAddress1();
		
		
		if(local!=null) {
			local = local.split(" ")[0]+" "+local.split(" ")[1];
		}else {
			local="";
		}
		
		DealService dService = new DealService();
		ArrayList<Deal> csList =null;
		ArrayList<DealAttachment> cdfList=null;
		int dealCount=0;
		if(cName!=null) {
			csList = dService.selectCategoryList(start,limit,cName,local);
			cdfList = dService.selectCategoryDaList(start, limit,cName,local);
			dealCount= dService.getDealCount(cName,local);
		}
		
		if(keyword!=null) {
			csList = dService.selectSearchList(start,limit,keyword,local);
			cdfList = dService.selectSearchDaList(start, limit,keyword,local);
			dealCount = dService.getDealCount(keyword,local);

		}
		System.out.println(dealCount);
		
		String page ="";
		
		if(csList!=null) {
			page="index.jsp";
			request.setAttribute("dList", csList);
			request.setAttribute("dfList", cdfList);
			request.setAttribute("keyword", keyword);
			request.setAttribute("dealCount", dealCount);
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg","카테고리 검색 중 오류가 발생했습니다.");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
