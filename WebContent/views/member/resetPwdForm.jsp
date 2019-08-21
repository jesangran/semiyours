<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>


<meta http-equiv="Content-Type" charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
		width:100%;
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


	<section class="wrapper">
		<div class="form-wrapper">
			<h2 id="title">비밀번호 재설정</h2>
			<form id="resetPwdForm" method="post" action="<%=request.getContextPath()%>/resetPwd.me">
			<input type =hidden name="email" value="<%=(String)request.getAttribute("email")%>">
				
				<div class="form-group">
					<label>새로운 비밀번호</label><br> 
					<input type=password  class="form-input newPwd1" id="newPwd1" name="newPwd1" >
				</div>
				<div class="form-group">
					<label>비밀번호 확인</label><br> 
					<input type=password  class="form-input newPwd" id="newPwd2" name="newPwd2"  >
				</div>
				
				<div class="form-group btns">
					<button class="form-button" id="goPwdResetBtn">확인</button>
					<button class="form-button" type="button" id="cancel" >취소</button>
				
				</div>			
			</form>
		</div>
	</section>
	
	<script>
	 	var pwdC = false;
	 	
		$("#newPwd1,#newPwd2").on("input",function(){
			var pwd1 =$("#newPwd1").val();
			var pwd2 =$("#newPwd2").val();
			console.log(pwd1);
			console.log(pwd2);
			 var regExpPw = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;

		
		
		if($(this).val().trim()==""){
			$(this).css("border","");
		}else{
			if(!regExpPw.test(pwd1)){
				$("#newPwd1").css("border","3px solid red");
			}
			else{	
				$("#newPwd1").css("border","3px solid lightgreen");
				if(pwd1==pwd2){
					$("#newPwd2").css("border","3px solid lightgreen");
					pwdC=true;
				}else{
					$("#newPwd2").css("border","3px solid red");
				}
					
			}
		}
	});
		$("#resetPwdForm").submit(function(){
			var check = true;
			if(!pwdC){check=false;}
			if(check==false){
				alert("입력 양식을 확인해주세요");
			}
			return check;
		});	
		
		$("#cancel").click(function(){
			location.href="<%=request.getContextPath()%>/select.de";
		});
		
	</script>

	
</body>
</html>