package deal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import deal.model.service.DealService;
import deal.model.vo.DealComment;
import member.model.vo.Member;

@WebServlet("/insertComment.de")
public class InsertDealCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertDealCommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNo =((Member)request.getSession().getAttribute("loginUser")).getUserNo()+"";
		String commentContent =request.getParameter("commentContent").replace("\n", "<br>");
		int dealNo = Integer.parseInt(request.getParameter("dealNo"));
		DealComment dComment = new DealComment(userNo,commentContent,dealNo);
		int result = new DealService().insertComment(dComment);
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
