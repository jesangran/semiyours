<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<meta http-equiv="Content-Type" charset="UTF-8">
<title>Insert title here</title>


<style>
*{
	box-sizing: border-box;
}
	body {
		width: 1280px;
		margin: 0 auto;
	}
	.wrapper{
		float:left;
		width:80%;
		height:800px;
	}
	.form-wrapper {
		
		width: 300px;
		margin:20px auto;
	}
	.form-group{
		margin: auto;
		width:100%;
	}
	.form-input {
		width: 100%;
		height:40px;
		border: 1px solid rgba(0, 0, 0, 0.2);
		border-radius: 5px;
		margin-bottom:10px;
	}
	.form-button {
	  width: 90px;
	  height:40px;
	  border-radius: 5px;
	  box-shadow: 10px; 
	  font-size:14px; 
	  background: darkgreen; 
	  color: white;
	  
	  
	  }
	.address {width: 400px;}
	#goPwdUpdateBtn,#cancel{
		width:140px;
		
	}
	.btns{
		
		text-align: center;
	}
	
	

</style>

</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/myPageSide.jsp"%>

	<section class="wrapper">
		<div class="form-wrapper">
			<h2 id="title">비밀번호 변경</h2>
			<form id="updatePwdForm" method="post" action="<%=request.getContextPath()%>/updatePwd.me">
				<div class="form-group">
					<label>현재 비밀번호</label><br> 
					<input type=password class="form-input pwd" id="pwd" name="pwd" >
				</div>
				<div class="form-group">
					<label>새로운 비밀번호</label><br> 
					<input type=password  class="form-input newPwd1" id="newPwd1" name="newPwd1" >
				</div>
				<div class="form-group">
					<label>비밀번호 확인</label><br> 
					<input type=password  class="form-input newPwd" id="newPwd2" name="newPwd2"  >
				</div>
				
				<input type="hidden" name="uno" value="<%=loginUser.getUserNo()%>">
				
				<div class="form-group btns">
					<button class="form-button" id="goPwdUpdateBtn">변경하기</button>
					<button class="form-button" id="cancel" >취소</button>
				
				</div>			
			</form>
		</div>
	</section>
	
	<%@ include file="../common/footer.jsp"%>


	
</body>
</html>