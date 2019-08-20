package customer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.model.service.NoticeService;
import customer.model.vo.PageInfo;


@WebServlet("/noticelist.bo")
public class pageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public pageListServlet() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		NoticeService nService = new NoticeService();
		
		int noticeCount = nService.getNoticeCount();
		
		int noticelimit = 5; // 한 페이지에 표현할 게시글 수
		int pagingBarSize = 10; // 보여줄 페이징바의 페이지 개수
		int currentPage = 0; // 현재 페이지 번호를 표시할 변수
		int maxPage = 0; // 전체 체이지에서 가장 마지막 페이지
		int startPage = 0; // 페이징바 시작 페이지 번호
		int endPage = 0; // 페이징바 끝 페이지 번호
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			// 아닌 경우, 현재 currentPage
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		maxPage = (int)Math.ceil((double)noticeCount / noticelimit);
		startPage = ((currentPage-1) / noticelimit) * pagingBarSize + 1;
		
		endPage = startPage + pagingBarSize -1;
		
		if(maxPage > endPage) {
			endPage = startPage + pagingBarSize -1;
		} else {
			endPage = maxPage;
		}
		PageInfo pInf = new PageInfo(noticeCount, noticelimit, pagingBarSize, currentPage, maxPage, startPage, endPage);
	
		ArrayList<Notice_vo> list = nService.selectPageList(currentPage, noticelimit);
		System.out.println("4");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
