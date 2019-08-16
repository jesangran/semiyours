<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

*{box-sizing: border-box;}
body{width:1280px;}
aside{
	float:left;
	width:20%;
	height:800px;
	border-right:1px solid lightgrey;
	margin:0;
}	
ul{
	list-style: none;
	margin:0;
	heigh:50px;
	font-size:20px;
}
.titleMypage{
	border:1px solid;
	margin-top:0;
	color:white;
	background: green;
	padding:20px;
}
.sideList{margin-bottom:30px; padding:5px; color:rgba(0,0,0,0.8)}
#myInfo{cursor: pointer;}


#updateInfo{
	font-weight: bolder;
	color:black;
}

</style>
</head>

<body>
	
	<aside>
		
			
			<ul>
				<li><h2 class="titleMypage">마이페이지</h2><li>
				<li class="sideList" id="myInfo">
				<div id="updateInfo">정보 수정</div>
				</li>
				<li class="sideList pick">
				<div>찜 내역 조회</div>
				</li>
				<li class="sideList dealhistoy">
				<div>거래 내역</div>
				</li>
				<li class="sideList myBoard" id="myBoard">
				<div>내가 쓴 게시글</div>
				</li>
				
			</ul>
		
	</aside>
	
	<script>
		$("#myInfo").click(function(){
			location.href="<%=request.getContextPath()%>/views/mypage/pwdInputForm.jsp";
		});
		
		$("#myBoard").click(function(){
			location.href="<%=request.getContextPath()%>/views/mypage/myBoard.jsp";
		});
		
	</script>
</body>
</html>