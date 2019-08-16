<%@page import="report.model.vo.PageInfo"%>
<%@page import="report.model.vo.Report"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Report>rList = (ArrayList<Report>)request.getAttribute("rList");
	PageInfo pInf =(PageInfo) request.getAttribute("pInf");
	
	int reportCount = pInf.getReportCount();
	int currentPage = pInf.getCurrentPage();
	int maxPage  = pInf.getMaxPage();
	int startPage = pInf.getStartPage();
	int endPage = pInf.getEndPage();
	int limit = pInf.getLimit();
	int pagingBarSize= pInf.getPagingBarSize();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width:1200px;
		height:700px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	table {
		width:100%;
		border:1px solid white;
		text-align:center;
	}
	.tableArea {
		/* width:650px;
		height:300px; */
		width:90%;
		height:550px;
		margin-left:auto; 
		margin-right:auto;
	}

	
	.pagingBtn{
		text-decoration: none;
		color : white;
		display : inline-block;
		width : 25px;
		height : 25px;
	}
	
	
	.listTitle{
		text-align: left;
		position: relative;
	}
	


</style>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/myPageSide.jsp"%>
	<div class="outer">
		<h3>나의 신고내용</h3>
		<div class="tableArea">
			<table>
				<tr>
					<th>신고번호</th>
					<th>신고물유형</th>
					<th>게시물번호</th>
					<th>신고사유</th>
					<th>신고상세</th>
					<th>신고일자</th>
				</tr>
				<% if(rList.isEmpty()) {%>
				<tr>
					<td colspan="5">등록된 게시글이 없습니다.</td>
				</tr>
				<%} else{ %>
					<%for(Report r : rList){ %>
					<tr id="listArea">
						<td><%=r.getReportNo() %></td>
						<td><%=r.getReportType() %></td>
						<td><%=r.getNo() %>
						<td><%=r.getReportReason() %></td>
						<td><%=r.getReportCon() %></td>
						<td><%=r.getReportDate() %></td>
					</tr>
					<%}
					}%>
			</table>
		</div>
		
			<!------- 페이징 바 ------->
		<!-- 페이징 처리 시작! -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로(<<) -->
			<span class="pagingBtn clickBtn" onclick="location.href='<%=request.getContextPath()%>/myReportList.bo?currentPage=1'">&lt;&lt;</span>
		
			<!-- 이전 페이지로(<) -->
			<% if(currentPage <=1) {%>
				<span class="pagingBtn">&lt;</span>
			<% } else{ %>
				<span class="pagingBtn clickBtn" 
					onclick="location.href='<%=request.getContextPath()%>/myReportList.bo?currentPage=<%= currentPage-1 %>'">&lt;</span>
			<% } %>
			
			<!-- 페이지 목록 -->
			<% for(int p = startPage; p <= endPage; p++){ %>
				<% if(p == currentPage) { %>
					<span class="pagingBtn selectBtn"><%= p %></span>
				<% } else{ %>
					<span class="pagingBtn clickBtn" 
						onclick="location.href='<%= request.getContextPath() %>/myReportList.bo?currentPage=<%= p %>'"><%=p%></span>
				<% } %>
			<%} %>
			
			<!-- 다음 페이지로(>) -->
			<% if(currentPage >= maxPage){ %>
				<span class="pagingBtn"> &gt; </span>
			<% } else{ %>
				<span class="pagingBtn clickBtn" 
					onclick="location.href='<%= request.getContextPath() %>/myReportList.bo?currentPage=<%= currentPage+1 %>'">&gt;</span>
			<% } %>
			
			<!-- 맨 끝으로(>>) -->
			<span class="pagingBtn clickBtn"
				onclick="location.href='<%= request.getContextPath() %>/myReportList.bo?currentPage=<%= maxPage %>'">&gt;&gt;</span>
		</div>
				
	</div>
	
	<script>
		$(function(){
			// 게시판 상세보기
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"darkgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"black"});
			}).click(function(){
				var bid = $(this).parent().children().eq(0).text();
				
<%-- 				// 로그인 한 사람만 게시글 상세보기 가능
				<% if(loginUser != null){ %>
					location.href="<%= request.getContextPath() %>/detail.bo?bid="+bid;
				<% } else{ %>
					alert("로그인해야만 상세보기가 가능합니다!");
				<% } %> --%>
			});
			
			
			// 페이징바 마우스오버 이벤트
			$(".clickBtn").mouseenter(function(){
				$(this).css({"background":"darkgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).css({"background":"black"});
			});
		});
		
	</script>
		
	
</body>
</html>