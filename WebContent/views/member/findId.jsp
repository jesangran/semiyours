<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../style/member/form.css" type="text/css">
<style>



</style>
</head>
<body>
	
	<div id="wrapper" >
			<form class="join-form" action="#" method="POST">
				<div class="form-header">
					<h3>아이디 찾기</h3>
				</div>
				<!--인증 가능 이메일 입력-->
				<div class="form-group">
					<input type="text" class="form-input" placeholder="인증 가능한 이메일을 입력하세요">
				</div>
				<div class="form-group">
					<button type="button" id="sendCertiNoBtn">인증번호 발송</button>
					<span></span>
				</div>
				<div class="form-group">
					<input type="text" class="form-input" placeholder="인증번호 입력">
				</div>
				<div class="form-group">
					<button type="button">인증번호 확인</button>
					<span id="timer"><span id="min">3</span><span>:</span><span id="sec">00</span></span>
				</div>
				<!--Login Button-->
				<div class="form-group">
					<button class="form-button" type="submit">확인</button>
				</div>
				<div class="form-group">
					<button class="form-button" id="cancel" type="reset">취소</button>
				</div>

			</form>


		</div>
	
	
	
</body>
</html>