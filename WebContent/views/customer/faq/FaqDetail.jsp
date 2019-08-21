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
#FD_outer {
	width: 800px;
	height: 800px;
}

#FD_content {
	text-align: center;
	border-collapse: collapse;
	width: 600px;
}

#FD_tableArea {
	width: 700px;
	height: 750px;
	margin-left: auto;
	margin-right: auto;
}

#FD_tableArea td {
	border-bottom: 1px solid black;
	height: 30px;
	text-align: left;
}

#FD_contents{
	background-color: bisque;
	width: 700px;
	height: 250px;
	margin-bottom: 20px;
	padding: 20px;
	overflow:auto;
}

#FD_tableArea hr {
	border-bottom: 1px solid #56A902;
}

.FD_title {
	font-size: 12px;
}
</style>
</head>
<body>
	<div id="FD_outer">
		<!-- FAQ게시판 틀 -->
		<br>
		<div id="FD_tableArea">
			<!-- FAQ게시판의 제목들 -->
			<br> <b>FAQ | 자주 묻는 질문과 답변 입니다.</b> <br>
			<br><hr>
			<br> Q.	<tr>
				<td class="FD_title"><%= fv.getFaqType()%></td> >
				<td class="FD_title"><%= fv.getFaqTitle()%></td>
			</tr>
			<br><br><hr><br>
			<table id ="FD_content" align="center">
				<!-- FAQ 테이블 -->
				<div id ="FD_contents">
					<%= fv.getFaqContent()%>
				</div>
			</table>
		</div>
		<br>
	</div>
</body>
</html>