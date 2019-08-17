package deal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import deal.model.service.DealService;
import deal.model.vo.Deal;
import deal.model.vo.DealAttachment;
import deal.model.vo.Local;

@WebServlet("/scroll.de")
public class ScrollSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ScrollSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DealService dService = new DealService();
		

		int limit = Integer.parseInt(request.getParameter("limit"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String local=request.getParameter("local");
		System.out.println(local+"asd");
		System.out.println(currentPage);
		System.out.println(limit);
		
		ArrayList<Deal> dList = dService.selectList(currentPage, limit,local);
		ArrayList<DealAttachment> dfList = dService.selectDFList(currentPage, limit,local);
		ArrayList<Local> lList = dService.selectLocal();
		request.setAttribute("lList", lList);
		String page = "";
		
		JSONArray Dealja = new JSONArray();
		JSONArray Daja = new JSONArray();
		JSONObject jo = new JSONObject();
		for(Deal deal : dList) {
			JSONObject d = new JSONObject();
			d.put("dealNo",deal.getDealNo());
			d.put("dealTitle", deal.getDealTitle());
			d.put("dealStatus", deal.getDealStatus());
			d.put("price", deal.getPrice());
			d.put("dealType", deal.getDealType());
			Dealja.add(d);
		}
		for(DealAttachment da : dfList) {
			Daja.add(da.getDaChange());
		}
		jo.put("count",dfList.size());
		jo.put("dList",Dealja);
		jo.put("dfList",Daja);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jo);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
