package mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import deal.model.vo.Deal;
import deal.model.vo.DealAttachment;
import mypage.model.service.MypageService;

@WebServlet("/scroll.my")
public class ScrollPickSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ScrollPickSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MypageService myService = new MypageService();
		

		int limit = Integer.parseInt(request.getParameter("limit"));
		int start = Integer.parseInt(request.getParameter("currentPage"));
		int uno=Integer.parseInt(request.getParameter("uno"));
		System.out.println(limit);
		System.out.println(start);
		System.out.println(uno);
		ArrayList<Deal> pList = myService.selectPick(start, limit,uno);
		ArrayList<DealAttachment> pfList = myService.selectPickFile(start, limit, uno);
		System.out.println(pList);
		
		JSONArray Dealja = new JSONArray();
		JSONArray Daja = new JSONArray();
		JSONObject jo = new JSONObject();
		for(Deal deal : pList) {
			JSONObject d = new JSONObject();
			d.put("dealNo",deal.getDealNo());
			d.put("dealTitle", deal.getDealTitle());
			d.put("dealStatus", deal.getDealStatus());
			d.put("price", deal.getPrice());
			d.put("dealType", deal.getDealType());
			d.put("dealLocal",deal.getDealLocal().split(" ")[0]+" "+deal.getDealLocal().split(" ")[1]);
			Dealja.add(d);
		}
		for(DealAttachment da : pfList) {
			Daja.add(da.getDaChange());
		}
		jo.put("count",pList.size());
		jo.put("pList",Dealja);
		jo.put("pfList",Daja);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jo);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
