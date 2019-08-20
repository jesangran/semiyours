<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../../style/member/form.css"
	type="text/css">
<style>

section{
	width:1280px;
	height:500px;
	border:1px;
}
.form-input {
	width: 270px;
	border: 1px solid rgba(0, 0, 0, 0.2);
	border-radius: 5px;
}

.form-button {
	width: 60px;
}

.address {
	width: 400px;
}

.formWrapper {
	width: 80%;
	float: left;
	
}

span{
	margin:auto;
}
.formWrapper div:first-child{
	width: 350px;
	margin:100px auto;
	

}


</style>
</head>
<body>

	

	<%@ include file="../common/header.jsp"%>
	
	
	
	
	<section>
		<%@ include file="../common/myPageSide.jsp"%>
		<p>&nbsp;&nbsp;&nbsp;<span>마이페이지</span><span>&nbsp; > &nbsp;</span><span>정보수정</span><p>
		<div class="formWrapper">
	
			<form method="post" action="<%=request.getContextPath()%>/encryptPwd.me" id="pwdCheckForm">
				<div >
				
					<div class="form-group">
						<label>정보수정을 위해 비밀번호를 입력해주세요</label><br>
						<input type="password" name="checkPwd" class="form-input pwd">
						<button class="form-button">확인</button>
					</div>
	
					<div class="form-group"></div>
				</div>
	
			</form>
	
	
		</div>
	</section>

	<%@ include file="../common/footer.jsp"%>
	<script>
	$(".updateInfo").css({"font-weight":"bolder","color":"black"});
	</script>

	
	
</body>
</html>