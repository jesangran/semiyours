<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, customer.model.vo.FaqVo, customer.model.vo.NoticeVo, customer.model.vo.PageInfo"%>
<%
/* 	ArrayList<FaqVo> FaqList = (ArrayList<FaqVo>) request.getAttribute("FaqList");
	ArrayList<NoticeVo> nList = (ArrayList<NoticeVo>) request.getAttribute("nList");
	PageInfo pInf = (PageInfo)request.getAttribute("pInf");*/
%>
<script>
var tab_urls = {
	"#FAQ_List_outer"   : "<%=request.getContextPath()%>/faqList.no",
	"#noticeList_outer" : "<%=request.getContextPath()%>/noticeList.no",
};
</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/customer/Service_js.js"
	type="text/javascript"></script>

<title>고객센터</title>

</head>
<body>
	<!-- 메인메뉴 경로 -->
	<%@ include file="/views/common/header.jsp"%>
	<link href="<%=request.getContextPath()%>/style/customer/ServiceCenter.css"
		rel="stylesheet" type="text/css">
	<div id="outer">
		<div class="board_top">
			<div class="tab_btn clearfix test">
				<div class="switching_btn">
					<button type="button" target="#FAQ_List_outer">FAQ</button>
				</div>
				<div class="switching_btn">
					<button type="button" target="#QNA_outer">문의하기</button>
				</div>
				<div class="switching_btn">
					<button type="button" target="#terms_outer">이용약관</button>
				</div>
				<div class="switching_btn">
					<button type="button" target="#noticeList_outer">공지사항</button>
				</div>
			</div>
			<div class="table_group">
				<hr/>
				<div class="imsi_outer" id="FAQ_List_outer">
					<%-- <%@ include file="/views/customer/faq/FaqList.jsp"%> --%>
				</div>
				<div class="imsi_outer" id="QNA_outer">
					<%@ include file="/views/customer/qna/QnaForm.jsp"%>
				</div>
				<div class="imsi_outer" id="terms_outer">
					<%@ include file="/views/customer/terms/TermsOfService.jsp"%>
				</div>
				<div class="imsi_outer" id="noticeList_outer">
					<%-- <%@ include file="/views/customer/notice/noticeList.jsp"%> --%>
				</div>
				<div class="imsi_outer" id="Ajax_outer">
					<button id="back" style="float:right;">이전으로</button>
					<div id="content"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>