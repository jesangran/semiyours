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
import deal.model.vo.DealComment;

@WebServlet("/selectComment.de")
public class SelectDealCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectDealCommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dealNo = Integer.parseInt(request.getParameter("dealNo"));
		ArrayList<DealComment> commList = new DealService().selectComment(dealNo);
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(commList,response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
