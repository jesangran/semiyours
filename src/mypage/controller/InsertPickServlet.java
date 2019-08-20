package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import mypage.model.service.MypageService;


@WebServlet("/updatePick.do")
public class InsertPickServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    
    public InsertPickServlet() {
        super();
       
    }


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("UTF-8");
      int pickNo = Integer.parseInt(request.getParameter("dNo"));
      int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
      
      
      int result = new MypageService().insertPick(pickNo, userNo);
      
      System.out.println(result);
      
      response.setCharacterEncoding("UTF-8");
      response.getWriter().print(result);
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      doGet(request, response);
   }

}