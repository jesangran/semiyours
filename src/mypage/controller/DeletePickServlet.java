package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import mypage.model.service.MypageService;

@WebServlet("/deletePick.my")
public class DeletePickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePickServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dNo = Integer.parseInt(request.getParameter("dNo"));
		int uno = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		System.out.println(dNo);
		System.out.println(uno);
		int result = new MypageService().deletePick(dNo,uno);
		response.getWriter().print(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
