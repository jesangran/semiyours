<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="customer.model.vo.FaqVo"%>
<%
	// NoticeDetailServlet에서 넘겨져온 Notice 받기
	FaqVo fv = (FaqVo) request.getAttribute("detail");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ상세 페이지</title>
<style>
#FAQ_Detail_outer {
	/* border:1px solid red; */
	width: 800px;
	height: 800px;
	/* background-color:blanchedalmond; */
}

table {
	text-align: center;
	border-collapse: collapse;
	width: 600px;
}

#FAQ_Detail_tableArea {
	/* border:1px solid red; */
	width: 700px;
	height: 750px;
	margin-left: auto;
	margin-right: auto;
}

td {
	border-bottom: 1px solid black;
	height: 30px;
	text-align: left;
}

.FAQ_title {
	font-size: 12px;
}

#FAQ_Contents {
	background-color: bisque;
	width: 700px;
	height: 250px;
	margin-bottom: 20px;
	padding: 20px;
	overflow:auto;
}

#list_go {
	float: right;
}

hr {
	border-bottom: 1px solid #56A902;
}
</style>
</head>
<body>
	<div id="FAQ_Detail_outer">
		<!-- FAQ게시판 틀 -->
		<br>
		<div id="FAQ_Detail_tableArea">
			<!-- FAQ게시판의 제목들 -->
			<br> <b>FAQ | 자주 묻는 질문과 답변 입니다.</b> <br>
			<br>
			<!-- <table id="FAQ_Top">
				<tr>
					<td>FAQ 검색</td>
					<td><input type="text" id="FAQ_Search"></td>
					<td><a href="">검색</a></td>
				</tr>
			</table> -->
			FAQ 검색<input type="text" id="FAQ_Search">
			<button type="submit">검색</button>
			<br><br><hr>
			<br> Q.	<tr>
				<td class="FAQ_title"><%= fv.getFaqType()%></td> >
				<td class="FAQ_title"><%= fv.getFaqTitle()%></td>
			</tr>
			<br><br><hr>
			<table align="center">
				<!-- FAQ 테이블 -->
				<div id="FAQ_Contents">
					<%= fv.getFaqContent()%>
				</div>
			</table>
		</div>
		<br>
	</div>
</body>
</html>