<%@page import="message.model.vo.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    	Message msg =(Message)request.getAttribute("msg");
    	
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
<style>
.msgArea {
	margin: 0;
	padding: 0;
	width: 500px;
	height: 400px;
}

#msgListArea {
	border: 1px solid darkgreen;
}

#msgTableArea {
	border-top: 1px solid;
	border-bottom: 1px solid;
	border-collapse: collapse;
	width: 100%;
}

#msgTableArea th {
	text-align: center;
	padding: 10px 8px;
}

#msgTableArea tr, #msgTableArea td {
	border: 0.5px solid lightgray;
	text-align: center;
	padding: 10px 8px;
}
</style>
</head>
<body>

	<div class="msgArea">
		<h2>쪽지창</h2>
		<hr>
		<div id="msgListArea">
			<table id="msgTableArea">
				<%if(msg != null) {%>
				<tr>
					<td>제목</td>
					<td id="mTitle"><%=msg.getmTitle() %></td>
				</tr>
				<tr>
					<td>발신인</td>
					<td id="mSender"><%=msg.getmSender() %></td>
				</tr>
				<tr>
					<td>발신일자</td>
					<td id="mEnrollDate"><%=msg.getmEnrollDate() %></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><%=msg.getmContent() %></td>
				</tr>
				<tr>
					<td></td>
					<td><button onClick="self.close();">닫기</button></td>
				</tr>
				<%} else{%>
				<tr>
					<td>잘못된 접근입니다.</td>
				</tr>
				<tr>
					<td></td>
					<td><button onClick="self.close();">닫기</button></td>
				</tr>
				<% }%>
			</table>
		</div>
	</div>

</body>
</html>