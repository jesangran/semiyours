<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../style/member/form.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>


	<div id="wrapper" >
			<form class="findpwd-form" action="<%=request.getContextPath()%>/findPwd.me" method="POST">
				<div class="form-header">
					<h3>비밀번호 찾기</h3>
				</div>
				<!--인증 가능 이메일 입력-->
				
				<div class="form-group">
					<input type="text" class="form-input" name="email" id="email" placeholder="가입된 이메일을 입력하세요">
				</div>
				<div class="form-group">
					<button type="button" id="sendCertiNoBtn" >인증번호 발송</button>
					<span></span>
				</div>
				<div class="form-group">
					<input type="text" class="form-input" id="certiNo" placeholder="인증번호 입력">
				</div>
				<div class="form-group">
					<button type="button" id="checkCertiNoBtn">인증번호 확인</button>
					<span id="timer"><span id="min">3</span><span>:</span><span id="sec">00</span></span>
					<span></span>
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
	
		<script>
		$(function() {
			var code;
			var emailC=false;
		
			var min = 2;
			var sec = 59;
			var secTimer;
	
			$("#sendCertiNoBtn").attr("disabled","disabled");
			$("#sendCertiNoBtn").click(function() {
				
			
				
				$("#checkCertiNoBtn").attr("disabled",false);
		
				$("#sendCertiNoBtn").siblings().text("인증번호를 발송하였습니다.").css({
					"fontSize" : "15px",
					"color" : "red"
				});
				
				$("#timer").css("display","inline");
				
				//3분 타이머
				secTimer = window.setInterval(function() {
					$("#min").text(min);
					if (sec < 0) {
						
						sec = 59;
					}
					if(sec==0){
						min--;
					}
					if(sec>=10){
						$("#sec").text(sec);
					}else{
						$("#sec").text("0"+sec);					
					}
					sec--;
				}, 1000);

			
				
				//인증시간 초과시
				window.setTimeout(function() {
					clearInterval(secTimer);
				
					$("#timer").text("")
					$("#timer").text("인증 시간이 초과되었습니다.").css({"fontSize" : "15px","color" : "red"});
					$("#checkCertiNoBtn").attr("disabled",false);
					resetTimer();
				}, 180000)
				
				var email=$("#email").val();
				$.ajax({
					url:"<%=request.getContextPath()%>/sendCertiNum.me",
					data:{email:email},
					type:"post",
					success:function(result){
						code=result;
					}
				});
				
				

			});
			
			
			
			
			
			
			/*인증버튼 클릭  */
			$("#checkCertiNoBtn").click(function(){
				
				if($("#certiNo").val().trim()==""){
					$("#timer").next().text("인증번호를 입력해주세요").css("color","red");						
					setTimeout(function(){
						$("#timer").next().text("");
					},2000);
					
				}else{
					if(code!=null){
						if($("#certiNo").val()==code){
							$("#timer").next().text("인증 완료").css("color","lightgreen");
							resetTimer();
							emailC=true;
						}else{
							$("#timer").next().text("인증번호가 틀렸습니다").css("color","red");
							setTimeout(function(){
								$("#timer").next().text("");
							},2000);
						}
					}else{
						$("#timer").next().text("인증번호가 틀렸습니다").css("color","red");
						setTimeout(function(){
							$("#timer").next().text("");
						},2000);
					}
				}
				
			});
			
			$(".findpwd-form").submit(function(){
				if($("#email").val().trim()==""){
					alert("이메일을 입력해주세요.");
					return false;
				}
				if(!emailC){ 
					 alert("인증이 완료되지 않았습니다.");
					return false;}
			});
			function resetTimer(){
				clearInterval(secTimer);
				min=2;
				sec=59;
				$("#timer").css("display","none"); 
				$("#min").text("3");
				$("#sec").text("00");
				
			}
			
			
			
			
			
			$("#email").on("input",function(){
				var email=$("#email").val();
				console.log(email);
				var regExp =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;

				if($("#email").val().trim()==""){
					$("#sendCertiNoBtn").attr("disabled","disabled");
					$("#email").css("border","");
				}else{
					if(!regExp.test(email)){
					$("#email").css("border","3px solid red");
					$("#sendCertiNoBtn").attr("disabled","disabled");
					}
					else{	
						
						$.ajax({
							url:"<%=request.getContextPath()%>/checkEmail.me",
							data:{email:email},
							type:"post",
							success:function(result){
								if(result>0){
								
									$("#email").css("border","3px solid lightgreen");
									$("#sendCertiNoBtn").attr("disabled",false);
									
								}else{
									$("#email").css("border","3px solid red");
								}
							}
						});
					}
				}
			});
			
			$("#cancel").click(function(){
				location.href="<%=request.getContextPath()%>/select.de";
			});
			
			
		});
				
	
			
			
			
			
		</script>
	
</body>
</html>