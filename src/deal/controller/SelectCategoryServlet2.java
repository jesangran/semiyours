package deal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import deal.model.service.DealService;
import deal.model.vo.Category2;

@WebServlet("/select2.cate")
public class SelectCategoryServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectCategoryServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cNo = Integer.parseInt(request.getParameter("cno").trim());
		ArrayList<Category2> cList = new DealService().selectCategory2(cNo);
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(cList,response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
