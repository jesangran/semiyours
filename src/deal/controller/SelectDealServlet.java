package deal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deal.model.service.DealService;
import deal.model.vo.Deal;
import deal.model.vo.DealAttachment;
import deal.model.vo.PageInfo;

@WebServlet("/select.de")
public class SelectDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectDealServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스 객체 생성 
				DealService dService = new DealService();
				
				int dealCount = dService.getDealCount();
				
				int limit = 16;     
				//int pagingBarSize = 10;    
				
				int currentPage = 0;        
				int maxPage = 0;            
				int row = 0;          
				int col = 0;         
				
				if(request.getParameter("currentPage") == null){
					currentPage = 1;
				}else {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				maxPage = (int)Math.ceil((double)dealCount / limit); 
				
				//startPage = ((currentPage-1)/limit) * pagingBarSize +1 ;
				//endPage = startPage + pagingBarSize -1; 
				
			
				
				PageInfo pInf = new PageInfo(dealCount, limit, currentPage, maxPage); 
				
				ArrayList<Deal> dList= dService.selectList(currentPage,limit);
				
				ArrayList<DealAttachment>dfList = dService.selectDFList(currentPage,limit);
				
				String page = "";
				System.out.println(dfList);
				if(dList!=null) {
					page= "index.jsp";
					request.setAttribute("dList", dList);
					request.setAttribute("pInf", pInf);
					request.setAttribute("dfList", dfList);
				}else {
					page = "views/common/errorPage.jsp";
					request.setAttribute("msg", "게시판 목록 조회 실패");
				}
				request.getRequestDispatcher(page).forward(request, response);
				
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
