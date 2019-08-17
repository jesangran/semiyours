<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="message.model.vo.Message"%>
<%
	ArrayList<Message> mList = (ArrayList<Message>) request.getAttribute("mList");
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
table {
	border-top: 3px solid #333;
	border-bottom: 1px solid green;
	border-collapse: collapse;
}

#recieveBox, #sendBox {
	border: 1px solid darkgreen;
	background-color: white;
	width: 70px;
	height: 50px;
	cursor: pointer;
}
#sendBox{
	background-color: lightgreen;
}
/* button:hover{
				background-color: #cff09e;
			} */
#recieveList:hover {
	background-color: #cff09e;
}

td, th {
	font-size: 12px;
	border-top: 1px solid #b2b2b2;
	border-bottom: 1px solid #b2b2b2;
	text-align: center;
	padding: 10px 8px;
}

.msgList:hover{
	cursor: pointer;
}

/* 페이징 */
.paging {
	margin-top: 15px;
}

.paging ul {
	text-align: Center;
}

.paging ul li {
	display: inline-block;
	margin-right: 2px;
	vertical-align: top;
}

.paging ul li:last-child {
	margin: 0;
}

.paging ul li a {
	display: block;
	font-size: 14px;
	color: #333;
	text-decoration: none;
	width: 24px;
	height: 24px;
	border: 1px solid #ddd;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
}

.paging ul li.on a, .paging ul li a:hover {
	background: #84bd00;
	color: #fff;
	border: 1px solid #84bd00;
}
</style>
</head>
<body>
	<div id="tabarea">
		<button id="recieveBox">수신함</button>
		<button id="sendBox">발신함</button>
	</div>
	<br>
	<div id="listarea">
		<table style="width: 100%">
			<colgroup>
				<col style="width: 10%">
				<col style="width: 10%">
				<col style="width: 35%">
				<col style="width: 15%">
				<col style="width: 20%">
				<col style="width: 10%">
			</colgroup>
			<tr>
				<th>열람</th>
				<th>번호</th>
				<th>제목</th>
				<th>수신자</th>
				<th>수신일자</th>
				<th>삭제</th>
			</tr>
			<tbody>
				<% if(mList.isEmpty()){ %>
				<tr>
				<td colspan="6">조회결과가 없습니다.</td>
				</tr>
				<%} else{%>
					<% for( Message m : mList){ %>
				<tr>
					<td><%=m.getmCondition() %></td>
					<td><%=m.getmNo() %></td>
					<td class="msgList"><%=m.getmTitle() %></td>
					<td><%=m.getmSender()%></td>
					<td><%=m.getmEnrollDate() %></td>
					<td><button class="deletebtn">삭제</button></td>
				</tr>
					<%} %>
				<%} %>
			</tbody>
		</table>
	</div>
	<div class="paging">
		<ul>
			<li class="prev"><a href="#;">&lt;</a></li>

			<li class="on"><a href="">1</a></li>
			<li><a href="">2</a></li>
			<li><a href="">3</a></li>
			<li><a href="">4</a></li>
			<li><a href="">5</a></li>

			<li class="next"><a href="#;">&gt;</a></li>
		</ul>
	</div>

	<script>
	$(function(){
		$("#recieveBox").click(function(){
			$("#recieveBox").css("background-color","#cff09e");
			location.href="<%=request.getContextPath()%>/recievemsg.me";
		});
		
		$("#sendBox").click(function(){
			$("#sendBox").css("background-color","#cff09e");
			location.href="<%=request.getContextPath()%>/sendmsg.me";
		});
		
		$(".msgList").on("click", function () {
			var mno = $(this).parent().children().eq(1).text();
			location.href="senddetailmsg.me?mno="+mno;
		});
		
		$(document).on("click", ".deletebtn", function() {
			var mno = $(this).parent().parent().children().eq(1).text();
			console.log(mno);
			var txt;
			var cf =confirm("쪽지를 정말로 삭제하시겠습니까?");
			var txt;
			if(cf == true){
				$.ajax({
					url: "recieveDeleteMsg.me", //서블릿
					Type: "POST",
					data: {mno:mno},
					success: function(result){
						if(result>0){
							alert("쪽지가 삭제되었습니다.");
							location.reload();
						}else{
							alert("운영자에게 문의해주세요.");
						}
					}
				});
			}else{
				txt = "취소합니다.";
			}
			
		});
		
		
	});
	

	
	
	</script>
</body>
</html>