<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/member/join.js"></script>
<!-- <link rel="stylesheet" href="style/common/index.css" type="text/css"> -->

<style>
	
body{
	height:800px;
	
}

#modal {
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.6);
	z-index: 30;
	position: fixed;
	left: 0;
    display:none;
	float: left;
}

#popup1 {
	border-radius: 5px;
	width: 500px;
	margin: 150px auto;
	border: 1px solid #ddd;
	padding: 2rem;
	background: #ffffff;
	border: 1px solid #014F01;
}

#popup2 {
	border-radius: 5px;
	width: 400px;

	margin: 100px auto;
	border: 1px solid #ddd;
	background: #ffffff;
	border: 1px solid #014F01;
	display: none;
}

.animate-pop {
	margin: auto;
	animation: animatepop 0.5s;
}


.form-input {
	background: #fafafa;
	width: 100%;
	border: 1px solid #eeeeee;
	padding: 12px;
	margin:10px;
	border-radius: 5px;
	
}

.form-group {
	margin-bottom: 1rem;
	width: 300px;
	margin:auto;
}

.form-button {
	background: darkgreen;
	border: 1px solid #ddd;
	color: #ffffff;
	padding: 10px;
	width: 100%;
	border-radius: 5px;
}

.form-button:hover {
	background: green;
}

.form-header {
	text-align: center;
	
}

.form-footer {
	font-size:12px;
	width:300px;
	text-align: left;
	color: #00007D;
	margin-bottom:50px;
	margin:auto;
	
}

.form-footer span {
	float: right;
	color: red;
	cursor: pointer;
}

input::placeholder {
	color: navy;
}
#timer{
	display:none;
}




  
          
	

</style>

</head>

<body>
	
	<% if(((Member)session.getAttribute("loginUser"))==null){%>
	<div id="modal" class="animate-pop">

		<div id="popup1">
			<form class="login-form"  action="<%=request.getContextPath()%>/login.me" method="POST">
				<div class="form-header">
					<h3>로그인</h3>
				</div>
				<!--Email Input-->
				<div class="form-group">
					<input type="text" class="form-input" id="loginEmail" name="loginEmail" placeholder="이메일을 입력해주세요.">
				</div>
				<!--Password Input-->
				<div class="form-group">
					<input type="password" class="form-input" id="logInPwd" name="loginPwd"  placeholder="비밀번호를 입력해주세요.">
				</div>
				<!--Login Button-->
				<div class="form-group">
					<button class="form-button" id="loginBtn" type="submit">로그인</button>
				</div>
				
			</form>
				<div class="form-footer">
					아직 회원이 아니세요? <span id="goJoinForm">회원가입하기</span>
				</div>
				<div class="form-footer">
					아이디를 잊어버리셨나요? <span id="goFindIdForm">아이디 찾기</span>
				</div>
				<div class="form-footer">
					비밀번호를 잊어버리셨나요? <span id="goFindPwdForm">비밀번호 찾기</span>
				</div>


		</div>
		<div id="popup2">
			<form class="join-form"  id="joinForm" action="join.me" method="POST">
				<div class="form-header">
					<h3>회원가입</h3>
				</div>
				<!--아이디 입력-->
				<div class="form-group">
					<input type="text" class="form-input" name="email" id="email" placeholder="사용 가능한 이메일">
				</div>
				
				<div class="form-group">
					<button type="button" id="sendCertiNoBtn" disabled >인증코드 발송</button>
					<span></span>
				</div>
				<div class="form-group">
					<input type="text" class="form-input" id="certiNo" placeholder="인증코드">
				</div>
				<div class="form-group">
					<button type="button" id="checkCertiNoBtn" disabled>인증 확인</button>
					<span id="timer"><span id="min">3</span><span>:</span><span id="sec">00</span></span>
					<span></span>
				</div>
				
				<!--비밀번호 입력-->
				<div class="form-group">
					<input type="password" class="form-input" id="pwd1" name="pwd1" placeholder="비밀번호">
				</div>
				<div class="form-group">
					<input type="password" class="form-input" id="pwd2" name="pwd2" placeholder="비밀번호 확인">
				</div>
				
				
				<div class="form-group">
					<input type="text" class="form-input" id="nickName" name="nickName" placeholder="닉네임">
				</div>
				<!--Login Button-->
				<div class="form-group">
					<button class="form-button" id="joinBtn">회원가입</button>
				</div>
				<div class="form-group">
					<button class="form-button" id="cancel" type="reset">취소</button>
				</div>

			</form>


		</div>
	</div>
	<%} %>
	

	<%@ include file="views/common/header.jsp"%>
	
	<%@ include file="views/common/saleList.jsp"%>
	

	<%@ include file="views/common/footer.jsp"%>
		
		
	<%if(loginUser!=null){%>
	<script >
		("*").off("click");
	</script>
		<%}%>
</body>




</html>