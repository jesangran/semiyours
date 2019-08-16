
	$(function() {
		var code;
		var emailC=false;
		var pwdC =false;
		var nickC=false;
	
		var min = 2;
		var sec = 59;
		var secTimer;
		
		/* 회원가입 span 클릭 시 로그인모달 사라지고 회원가입 모달 띄우기  */
		$("#goJoinForm").click(function() {
			$("#popup1").css("display", "none");
			$("#popup2").css("display", "block");
		});
		$("#cancel").click(function() {
			$("#popup1").css("display", "block");
			$("#popup2").css("display", "none");
		});
		
		
		
		/*--------------인증코드 보내기 -----------------------------------  */

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
				url:"sendCertiNum.me",
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
		
		
		function resetTimer(){
			clearInterval(secTimer);
			min=2;
			sec=59;
			$("#timer").css("display","none"); 
			$("#min").text("3");
			$("#sec").text("00");
			
		}
		
		/*-----------------이메일 중복검사-------------------  */
		
		$("#email").on("input",function(){
			var email=$("#email").val();
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
						url:"checkEmail.me",
						data:{email:email},
						type:"post",
						success:function(result){
							if(result==0){
							
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
		
		$("#pwd1,#pwd2").on("input",function(){
			var pwd1 =$("#pwd1").val();
			var pwd2 =$("#pwd2").val();

			 var regExpPw = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;

			
			
			if($(this).val().trim()==""){
				$(this).css("border","");
			}else{
				if(!regExpPw.test(pwd1)){
					$("#pwd1").css("border","3px solid red");
				}
				else{	
					$("#pwd1").css("border","3px solid lightgreen");
					if(pwd1==pwd2){
						$("#pwd2").css("border","3px solid lightgreen");
						pwdC=true;
					}else{
						$("#pwd2").css("border","3px solid red");
					}
						
				}
			}
		});
		
		$("#nickName").on("input",function(){
			var nick=$("#nickName").val();
			var regExpNick =/^[가-힣a-zA-Z\d]{2,6}$/;

			if($(this).val().trim()==""){
				$(this).css("border","");
			}else{
				if(!regExpNick.test(nick)){
					$(this).css("border","3px solid red");
				}
				else{	
					
					$.ajax({
						url:"checkNick.me",
						data:{nick:nick},
						type:"post",
						success:function(result){
							console.log(result);
							if(result==0){
								$("#nickName").css("border","3px solid lightgreen");
								nickC=true;
							}else{
								$("#nickName").css("border","3px solid red");
							}
						}
					});
				}
			}
		});
		
		$("#joinForm").submit(function(){
			var check = true;
		 	if(!emailC){check=false;}
			if(!pwdC){check=false;}
			if(!nickC){check=false;}
			if(check==false){
				alert("입력 양식을 확인해주세요");
			}
			return check;
		});
		
		
		
		$("#cancel").click(function(){
			resetTimer();
			$("input:text,input:password").css("border","");
			$("#sendCertiNoBtn").siblings().text("");
		});
		
		

/*------------------로그인창 하단 -------------------------  */
		$("#goFindIdForm").click(function(){
			location.href="views/member/findId.jsp";
		});
		$("#goFindPwdForm").click(function(){
			location.href="views/member/findPwd.jsp";
		});
		
		$("body").click(function(){
	
			$("#modal").css("display","block");
		});
		
		
		
		
		

	});
