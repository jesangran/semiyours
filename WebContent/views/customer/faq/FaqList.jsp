<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, customer.model.vo.FaqVo, customer.model.vo.PageInfo"%>
<%
	ArrayList<FaqVo> FaqList = (ArrayList<FaqVo>) request.getAttribute("FaqList");
	PageInfo pInf = (PageInfo)request.getAttribute("pInf");

	int FaqCount      = pInf.getFaqCount();
	int currentPage   = pInf.getCurrentPage();
	int maxPage       = pInf.getMaxPage();
	int startPage     = pInf.getStartPage();
	int endPage       = pInf.getEndPage();
	int Faqlimit      = pInf.getFaqlimit();
	int pagingBarSize = pInf.getPagingBarSize();
%>
<!-- FAQ게시판 -->
<div id="FAQ_List_tableArea" class="table">
	<!-- FAQ게시판의 제목들 -->
	<!-- <br> <b>FAQ | 자주 묻는 질문과 답변 입니다.</b> <br> <br> FAQ 검색<input
		type="text" id="FAQ_Search">
	<button type="submit">검색</button>
	<br> <br> <br> -->
	<%-- 검색어'검색결과 : 총 <%=fo.getFaqNo()%> 건 --%>
	<hr>
	<br>
	<table align="center" id="FAQ_listArea">
		<!-- FAQ 테이블 -->

		<thead>
			<th class="FAQ_List_title">FAQ 번호</th>
			<th class="FAQ_List_title">FAQ 분류</th>
			<th class="FAQ_List_title">FAQ 제목</th>
		<thead>
		<tbody>
			<%
				if (!FaqList.isEmpty()) {// 호출되어 간때 완성 됨
			%>
			<%
				for (FaqVo fo : FaqList) {// 호출되어 간때 완성 됨
			%>
			<tr>
				<td><%=fo.getFaqNo()%></td>
				<td><%=fo.getFaqType()%></td>
				<td align="left"><%=fo.getFaqTitle()%></td>
			</tr>
			<%
				}
			%>
			<%
				} else {
			%>
			<tr>
				<td colspan="3">조회 결과가 없습니다.</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>
<br>
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
	<%
		if (currentPage >= maxPage) {
	%>
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