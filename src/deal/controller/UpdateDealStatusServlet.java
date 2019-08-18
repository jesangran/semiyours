package deal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deal.model.service.DealService;

@WebServlet("/updateStatus.de")
public class UpdateDealStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateDealStatusServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dealNo = Integer.parseInt(request.getParameter("dealNo"));
		String dealStatus = request.getParameter("status");
		int statusNo=0;
		if(dealStatus.equals("판매중")) {statusNo=1;}
		else if(dealStatus.equals("거래중")) {statusNo=2;}
		else {statusNo=3;}
		int result = new DealService().updateStatus(dealNo,statusNo);
		response.getWriter().print(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
