<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="customer.model.vo.NoticeVo"%>
<%
	NoticeVo nv = (NoticeVo) request.getAttribute("nDetail");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지상세 페이지</title>
<style>
#notice_Detail_outer {
	/* border:1px solid red; */
	width: 800px;
	height: 800px;
	/* background-color:blanchedalmond; */
}

#InformArea {
	text-align: center;
	border-collapse: collapse;
}

#detailArea {
	/* border:1px solid red; */
	width: 700px;
	height: 750px;
	margin-left: auto;
	margin-right: auto;
	/* border: 1px solid gray; */
}

#InformArea th {
	border-bottom: 2px solid #56A902;
	height: 50px;
	font-size: 14px;
}

.wrap {
	/* border:1px solid black; */
	width: 680px;
	height: 400px;
	overflow: auto;
}

#list_go {
	float: right;
}
</style>
</head>
<body>
	<div id="notice_Detail_outer">
		<!-- 공지사항이 들어갈 틀 -->
		<br>
		<!-- 공지사항 상세페이지 -->
		<div id="detailArea" align="center">
			<table align="center" id="InformArea">
				<!-- 공지사항 테이블 -->
				<tr>
					<!-- 테이블 길이 width : 700 -->
					<th width="500px"><%=nv.getNoticeTitle()%></th>
					<th width="200px"><%=nv.getNoticeEnrolldate()%></th>
				</tr>
			</table>
			<br>
			<div class="wrap">
				<%=nv.getNoticeContent()%>
			</div>
			<br>
			<!--<button id="list_go"><a href="ServiceCenter.jsp"> 목록으로</a></button>-->
			<!-- <button id="list_go" onclick="history.go(-1)">목록으로</button> -->
		</div>
	</div>
</body>
</html>