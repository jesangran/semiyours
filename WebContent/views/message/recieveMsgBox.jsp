<%@page import="message.model.vo.PageInfo"%>
<%@page import="message.model.vo.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Message> mList = (ArrayList<Message>) request.getAttribute("mList");
	PageInfo pInf = (PageInfo)request.getAttribute("pInf");
	
	int msgCount = pInf.getMsgCount();
 	int currentPage = pInf.getCurrentPage();
 	int maxPage =pInf.getMaxPage();
 	int startPage = pInf.getStartPage();
 	int endPage = pInf.getEndPage();
 	int limit = pInf.getLimit();
 	int pageBarSize = pInf.getPagingBarSize();
	System.out.println(pInf);
	System.out.println(mList);
 	
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
	background-color:white;
	width: 70px;
	height: 50px;
	cursor: pointer;
	}
	#recieveBox{
		background-color: lightgreen;
	}
#recieveList:hover {
	background-color: #cff09e;
}

.msgList:hover{
	cursor: pointer;
}

td, th {
	font-size: 12px;
	border-top: 1px solid #b2b2b2;
	border-bottom: 1px solid #b2b2b2;
	text-align: center;
	padding: 10px 8px;
}

.deletebtn{
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}

/* 페이징 */
.paging {
	margin-top: 15px;
	text-align: Center;
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
				<col style="width: 8%">
				<col style="width: 35%">
				<col style="width: 15%">
				<col style="width: 20%">
				<col style="width: 12%">
			</colgroup>
			<tr>
				<th>열람</th>
				<th>NO</th>
				<th>제목</th>
				<th>발신자</th>
				<th>수신일자</th>
				<th>삭제</th>
			</tr>
			<tbody>
		<!-- 조회시 아래 테이블 출력 -->
				<% if(mList.isEmpty()){ %>
			
			<tr>
				<td colspan="6">조회결과가 없습니다.</td>
			</tr>
			<%} else{%>
			<% for(Message m : mList){ %>
			<tr >
				<td><%=m.getmCondition() %></td>
				<td><%=m.getmNo() %></td>
				<td  class="msgList"><%=m.getmTitle() %></td>
				<td><%=m.getNickname() %></td>
				<td><%=m.getmEnrollDate() %></td>
				<td><button class="deletebtn">삭제</button></td>
			</tr>
			<%} %>
			<%} %>
			</tbody>
		</table>
	</div>
	<div class="paging">
		<span class="pagingBtn clickBtn" onclick="location.href='<%= request.getContextPath() %>/recievemsg.me?currentPage=1'">&lt;&lt;</span>
		<!-- 이전 페이지로(<) -->
			<% if(currentPage <= 1) { %>
				<span class="pagingBtn">&lt;</span>
			<% } else{ %>
				<span class="pagingBtn clickBtn" 
					onclick="location.href='<%= request.getContextPath() %>/recievemsg.me?currentPage=<%= currentPage-1 %>'">&lt;</span>
			<% } %>
			
			<!-- 페이지 목록 -->
			<% for(int p = startPage; p <= endPage; p++){ %>
				<% if(p == currentPage) { %>
					<span class="pagingBtn selectBtn"><%= p %></span>
				<% } else{ %>
					<span class="pagingBtn clickBtn" 
						onclick="location.href='<%= request.getContextPath() %>/recievemsg.me?currentPage=<%= p %>'"><%=p%></span>
				<% } %>
			<%} %>
			
			<!-- 다음 페이지로(>) -->
			<% if(currentPage >= maxPage){ %>
				<span class="pagingBtn"> &gt; </span>
			<% } else{ %>
				<span class="pagingBtn clickBtn" 
					onclick="location.href='<%= request.getContextPath() %>/recievemsg.me?currentPage=<%= currentPage+1 %>'">&gt;</span>
			<% } %>
			
			<!-- 맨 끝으로(>>) -->
			<span class="pagingBtn clickBtn"
				onclick="location.href='<%= request.getContextPath() %>/recievemsg.me?currentPage=<%= maxPage %>'">&gt;&gt;</span>
	</div>

	<script>
	
		$(function(){
			$("#recieveBox").click(function(){
				$("#recieveBox").css("background-color","#cff09e");
				location.href="<%=request.getContextPath()%>/recievemsg.me";
			}); //수신함이동
			
/* 			// 페이징바 마우스오버 이벤트
			$(".clickBtn").mouseenter(function(){
				$(this).css({"background":"darkgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).css({"background":"black"});
			}); */
			
			$("#sendBox").click(function(){
				$("#sendBox").css("background-color","#cff09e");
				location.href="<%=request.getContextPath()%>/sendmsg.me";
			}); //발신함 이동			
			
			$(".msgList").on("click", function (){
				var mno = $(this).parent().children().eq(1).text();
				location.href="recievedetailmsg.me?mno="+mno;
			}); //수신메시지 새창
		
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