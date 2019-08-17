package customer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.model.service.FaqService;
import customer.model.service.NoticeService;
import customer.model.vo.FaqVo;
import customer.model.vo.NoticeVo;
import customer.model.vo.PageInfo;


@WebServlet("/faqList.no")
public class faqList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public faqList() {super();}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// 		FAQ 서비스 객체 생성
				FaqService fService = new FaqService();
				
				int FaqCount = fService.FaqCount();
				
				 
				
				// 페이징 처리용 변수 선언
				int limit = 10;          // 한 페이지에 보여질 게시글 수
				int pagingBarSize = 10;  // 보여질 페이징바의 페이지 개수

				int currentPage = 0;     // 현재 페이지 번호를 표시할 변수
				int maxPage = 0;         // 전체 페이지에서 가장 마지막 페이지
				int startPage = 0;       // 페이징바 시작 페이지 번호
				int endPage = 0;         // 페이징바 끝 페이지 번호
				
				// currentPage - 현재 페이지 번호를 표시할 변수
				if(request.getParameter("currentPage") == null) {
					// 처름 게시판 목옥으로 화면 전환 시 1체이지가 보이도록 함.
					
					currentPage = 1;
				}else {
					// 아닌 경우, 현재 currentPage
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
				// maxPage - 총 페이지 수
				// 게시글의 개수가 100개일 경우 필요 페이지 : 10페이지
				// 게시글의 개수가 101개일 경우 필요 페이지 : 11페이지
				// 전체 게시글 수 / 한 페이지에 보여질 수 있는 게시글 개수
				// 위 결과를 올림처리함.
				maxPage= (int)Math.ceil((double)FaqCount / limit);
				
				// startPage - 페이징바 시작 페이지 번호
				// 페이징바에 숫자가 10개씩 표시되는 경우
				// 1, 11, 21, 31, ... -> 10(n-1) + 1
				startPage = ((currentPage-1) / limit) * pagingBarSize + 1;
				
				// endPage - 페이징바 끝 페이지 번호
				// 페이징바에 숫자가 10개씩 표시되는 경우
				// 10, 20, 30, 40, ...
				endPage = startPage + pagingBarSize -1;
				
				if(maxPage > endPage) {
					endPage = startPage + pagingBarSize - 1;
				}else {
					endPage = maxPage;
				}
				
				System.out.println(FaqCount + " , " + limit + " = " + maxPage);
				PageInfo pInf = new PageInfo(FaqCount, limit, pagingBarSize, currentPage, maxPage, startPage, endPage);
				
				// ------- 페이징바 처리 끝 -------
						
				// ------- 게시글 목록 조회 시작 -------
				
				ArrayList<FaqVo> FaqList = fService.FaqSelectList(currentPage, limit);
				
				String page = "";
				if( FaqList != null) {
					page = "views/customer/faq/FaqList.jsp";
					request.setAttribute("FaqList",  FaqList);
					request.setAttribute("pInf",  pInf);
				}else {
					page = "views/board/errorPage.jsp";
					request.setAttribute("msg", "게시판 목록 조회 실패");
				}
				request.getRequestDispatcher(page).forward(request, response);
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);}
}































