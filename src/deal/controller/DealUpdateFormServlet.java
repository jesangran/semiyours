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
import deal.model.vo.Category1;
import deal.model.vo.Category2;
import deal.model.vo.Deal;
import deal.model.vo.DealAttachment;

@WebServlet("/updateForm.de")
public class DealUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public DealUpdateFormServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dealNo = Integer.parseInt(request.getParameter("dealNo"));
		DealService dService = new DealService();
		Deal deal = dService.selectDeal(dealNo);
		ArrayList<DealAttachment> file = dService.selectFile(dealNo);
		ArrayList<Category1> c1List = dService.selectCategory1();
		ArrayList<Category2> c2List=null;
		for(Category1 c1 : c1List) {
			if(c1.getcName().equals(deal.getDept1())) {
				System.out.println(c1.getcNo());
				c2List = dService.selectCategory2(c1.getcNo());
				break;
			}
		}
		System.out.println(c2List);
		String page ="";
		RequestDispatcher view = null;
		if(deal!=null && !file.isEmpty()) {
			page ="views/deal/dealUpdateForm.jsp";
			request.setAttribute("deal", deal);
			request.setAttribute("file", file);
			request.setAttribute("c1List", c1List);
			request.setAttribute("c2List", c2List);
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("errorMsg","정보를 불러오는 중에 에러가 발생했습니다.");
		}
		view=request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
