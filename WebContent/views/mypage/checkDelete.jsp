<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
<style>

.alert {
	float: left;
	width: 500px;
	height: 300px;
	border: 0.5px solid red;
	background-color: lightcoral;
	opacity: 0.6;
	margin-top: 40px;
	margin-left: 60px;
}

#text {
	text-align: center;
	font-size: 15px;
	font-weight: 900;
	line-height: 35px;
	color: black;
	padding: auto;
	margin-top: 30px;
}

#btnarea {
	text-align: center;
	padding: auto;
	margin-top: 10px;
}

#okbtn, #nobtn {
	border: 0.5px solid darkblue;
	background-color: white;
	height: 30px;
	text-align: center;
	font-weight: 600;
	color: black;
}

</style>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/myPageSide.jsp"%>
	<div class="alert">
		<br>
		<div id="text">
			회원을 탈퇴합니다. <br> 회원을 탈퇴하시겠습니까?<br>
		</div>
		<br>
		<div id="btnarea">
			<button id="okbtn">네, 탈퇴할래요</button>
			<button id="nobtn">아니요</button>
		</div>
	</div>
	
	<script>
		$("#okbtn").click(function() {
			var cf = confirm("정말탈퇴하시겠습니까?");
			if(cf == true){
				location.href = "<%=request.getContextPath()%>/deleteMember.me";
			}else{
				location.href = "<%=request.getContextPath()%>";
			}
		});
		$("#nobtn").onclick(function() {
			location.href ="<%=request.getContextPath()%>";
		});
	
	</script>
	
</body>
</html>