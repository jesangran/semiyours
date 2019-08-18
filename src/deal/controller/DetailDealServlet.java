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

@WebServlet("/detail.de")
public class DetailDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailDealServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dealNo = Integer.parseInt(request.getParameter("dealNo"));
		DealService dService = new DealService();
		Deal deal = dService.selectDeal(dealNo);
		ArrayList<DealAttachment> daList = dService.selectFile(dealNo);
		String page ="";
		if(deal!=null && !daList.isEmpty()) {
			page= "views/deal/DealDetailView.jsp";
			request.setAttribute("deal", deal);
			request.setAttribute("daList", daList);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("errorMsg", "게시글 조회중 오류가 발생하였습니다.");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
