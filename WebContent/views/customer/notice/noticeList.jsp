<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, customer.model.vo.NoticeVo, customer.model.vo.NoticePageInfo"%>
<%
	ArrayList<NoticeVo> nList = (ArrayList<NoticeVo>)request.getAttribute("nList");
	NoticePageInfo pInf = (NoticePageInfo)request.getAttribute("pInf");
	
	int nCount        = pInf.getnCount();        // 게시글수
	int currentPage   = pInf.getCurrentPage();   // 현재 페이지의 게시글 수
	int maxPage       = pInf.getMaxPage();       // 전체 페이지의 마지막 페이지 번호
	int startPage     = pInf.getStartPage();     // 시작하는 페이지(첫페이지)
	int endPage       = pInf.getEndPage();       // 끝 페이지
	int nLimit        = pInf.getNlimit();        // 한 페이지의 게시글 수
	int pagingBarSize = pInf.getPagingBarSize(); // 페이징 바의 페이지 번호 수

%>
<%-- <script>
var tab_urls = {
	"#noticeList_outer" : "<%=request.getContextPath()%>/noticeList.no"
};
</script> --%>
<div id="noticeList_tableArea" class="table">
	<!-- 공지사항 내용이 대한 제목들 -->
	<table align="center" id="noticeList_listArea">
		<!-- 공지사항 테이블 -->

		<thead>
			<th width="100px">번호</th>
			<th width="400px">제목</th>
			<th width="100px">작성일</th>
			<th width="100px">조회수</th>
		</thead>
		<%if (!nList.isEmpty()) {%>
		<%for (NoticeVo no : nList) {%>
		<tr>
			<!-- 글번호, 제목, 작성일(등록일), 조회수  -->
			<td><%=no.getNoticeNo()%></td>
			<td><%=no.getNoticeTitle()%></td>
			<td><%=no.getNoticeEnrolldate()%></td>
			<td><%=no.getNoticeCount()%></td>
		</tr>
		<% } %>
		<% } else { %>
		<tr> 
			<td colspan="4">등록 내용이 없습니다.</td> 
		</tr>
		<% } %>
	</table>
</div>
<!------- 페이징 바 ------->
<!-- 페이징 처리 시작! -->
<div class="pagingArea" align="center">
	<!-- 맨 처음으로(<<) -->
	<span class="pagingBtn clickBtn">&lt;&lt;</span>

	<!-- 이전 페이지로(<) -->
	<%
		if (currentPage <= 1) {
	%>
	<span class="pagingBtn">&lt;</span>
	<%
		} else {
	%>
	<span class="pagingBtn clickBtn">&lt;</span>
	<%
		}
	%>

	<!-- 페이지 목록 -->
	<%
		for (int p = startPage; p <= endPage; p++) {
	%>
	<%
		if (p == currentPage) {
	%>
	<span class="pagingBtn selectBtn"><%=p%></span>
	<%
		} else {
	%>
	<span class="pagingBtn clickBtn"><%=p%></span>
	<%
		}
	%>
	<%
		}
	%>

	<!-- 다음 페이지로(>) -->
	<% if (currentPage >= maxPage) { %>
	<span class="pagingBtn"> &gt; </span>
	<%
		} else {
	%>
	<span class="pagingBtn clickBtn">&gt;</span>
	<%
		}
	%>

	<!-- 맨 끝으로(>>) -->
	<span class="p  agingBtn clickBtn">&gt;&gt;</span>
</div>
<script>
	$(function(){
		// 페이징바 마우스오버 이벤트
		$(".clickBtn").mouseenter(function() {
			$(this).css({
				"background" : "darkgray",
				"cursor" : "pointer"
			});
		}).mouseout(function() {
			$(this).css({
				"background" : "white"
			});
		});
	});
</script>