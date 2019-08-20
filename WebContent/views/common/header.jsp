
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.model.vo.Member"%>

<%

String mMsg =(String)session.getAttribute("mMsg");
String msg =(String)request.getAttribute("msg");
Member loginUser = (Member)session.getAttribute("loginUser");
String encPwd =(String)request.getAttribute("encPwd"); 
Member member = (Member)session.getAttribute("member");
if(loginUser!=null && member!=null){
	loginUser =member;
} 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   		<!-- <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet"> -->
	  <%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/style/common/header.css" type="text/css"> --%>
<style>

*{
	box-sizing: border-box;
}
body{
    width: 1280px;
    height:800px;
 	margin:auto;
    font-family: 'Noto Sans KR', sans-serif;
    /*  font-family:'Malgun Gothic'; */
	
   
}

header, nav, section, footer{
	
    box-sizing: border-box;
    display: block;
/*  border: 1px solid black;  */
}
section{
	height:300px
}
header{

    width: 100%;
    height:200px;
    text-align: center;
}
header article{
    float: left;
    width: 15%;
    height: 100%;
    font-size: 18px;
    font-weight:bolder;
    color:darkgreen;
}
#articleSec{
    width: 100%;
    height: 80%;
}
#articleP{
    width: 100%;
    height: 20%;
}
#headerSec1{
    width: 70%;
    height: 100%;
    float: left;
    font-size: 12px;

}
#headerSec2{
    width: 15%;
    height: 100%;
    float: left;
    text-align: right;
    font-size: 12px;
}
#mainlogo{
    width: 25%;
    height: 25%;
    margin:25px 0 25px 0;
}

	
#searchBox{
    width: 300px;
  	height:35px;
    border: 2px solid darkgreen;
    border-radius:5px;
    margin-left:0;
	
		

}
#searchBtn{
	display:inline-block;
    width: 75px;
	height:35px;
    border: 2px solid darkgreen;
    border-radius:5px;
    background-color: white;
		font-size:15px;
		line-height: 28.5px;
}
.keyword{
	
		
	top:145px;
	left:850px;
	margin:auto;
}
.keyword>span{
	display:inline-block;
	margin:0 5px 0 0;
	font-size: 14px;
}
.mydeallocal{
	font-size:15px;
}
#searchBtn:hover{
    cursor: pointer;
    background-color: yellowgreen;
}
#headerSec2>div>span{
	margin-right: 27px;
	font-size:14px;
}
#headerSec2>div{
	width:100%;
}



[data-notifications]:after {
    content: attr(data-notifications);
    position: absolute;
    background: red;
    border-radius: 50%;
    display: inline-block;
    padding: 0.15em;
    color: #f2f2f2;
    top: -1.5px;
  
    
} 

.menu{
    color: darkgreen;
    font-family: 'Noto Sans KR', sans-serif;
    width: 100%;
    height: 10%;
    clear: both;
    margin:0;
	
}
.menu>ul{
	width:100%;
	height: 100%;
		list-style: none;
}
.menu>ul>li{

	height: 100%;
    float: left;
    width: 20%;
    font-size: 18px;
    color: darkgreen;
    font-weight: bolder; 

    text-align: center;
    position: relative;
}

.menu>ul>li:hover{
	cursor:pointer;
}

	.menu>ul>li>div:first-child{
	display: inline-block;
	height: 100%;
	width:10%;
	}
	 .menu>ul>li>div:nth-child(2){
	display: inline-block;
	height: 100%;
	width:35%;
	position: absolute;
	top:0;

	}

.categoryImg{
	height: 100%;
}
#logout:hover{
	cursor: pointer;
}

</style>


</head>



<body>
	
	
	<%if(mMsg!=null){ %>
	<script>
		alert("<%=mMsg%>");
	</script>
	<%
	}
	session.removeAttribute("mMsg");
	%>
	
	<%if(msg!=null){ %>
	<script>
		alert("<%=msg%>");
	</script>
	<%
		msg=null;
	}
	%>
	
	
	<%if(encPwd!=null){ 
		if(encPwd.equals(loginUser.getPwd())){%>
		<script> 
			location.href="<%=request.getContextPath()%>/views/mypage/memberInfo.jsp";
		</script>
		<%}else{ %>
		
		<script>
			alert("비밀번호가 틀렸습니다.");
			location.href="<%=request.getContextPath()%>/views/mypage/pwdInputForm.jsp";
		</script>
		
	<%}
		encPwd=null;
		}%>
	

	
	<section class="hearderWrap">
	  <header>
        <article>
            <div id="articleSec">
            <%if(loginUser!=null){ %>
            <img src="<%=request.getContextPath()%>/images/local.png" width="50%" height="80%"></img>
	             <%if(loginUser.getAddress1()!=null){ %>
	            <div>
	            <span class="mydeallocal l1"><%=loginUser.getAddress1().split(" ")[0] %></span>
	            <span class="mydeallocal l2"><%=loginUser.getAddress1().split(" ")[1] %></span>
	            </div>
	            <%}else{%>
	            <div>주소를 등록해주세요</div>
	            <%}%>
            <%}%>
            </div>
          
        </article>
        
        
        <section id = headerSec1>
            <a href="<%=request.getContextPath()%>/select.de"><img src="<%=request.getContextPath()%>/images/logo.png" id= "mainlogo"></a>
            <form id="searchFrm" name="searchFrm" method="GET">
            	<div class="searchWrapper">
	                <input type="text" id = "searchBox">
	                <span id="searchBtn">검색</span>
	                <!-- <input type="submit" id="searchBtn" value="검색"> -->
            	</div>
               
            </form>
        	<p class=keyword>
       
        	<%for(int i=0; i<5; i++){ %>
        	
	        	<span> <a class="keyword" href="asd"> 키워드<%=i+1 %> </a> </span>	
	        <%} %>
	        	
        	</p>
        </section>
        
        
        <section id="headerSec2">
        	
        		<div>
	         
	        	<% if(loginUser!=null){%>
	        	<span data-notifications="00" id="message">쪽지</span>
	            <span data-notifications="00" id="notice">알림</span>
	            <span  id="logout">로그아웃</span>
	      		<%}else{ %>
	    		  <span  id="login">로그인</span>
	       		<%} %> 
        		</div>
        </section>
    </header>


   





   <hr>
    <nav class="menu">


        <ul>
            <li id="category">
            <div><img src="<%=request.getContextPath()%>/images/list.png" class="categoryImg"></div><div>카테고리</div></li>
            <li id="sale">물건팔기</li>
            <li id="communtiy">커뮤니티</li>
            <li id="mypage">마이페이지</li>
            <li id="customer"><div onclick="gocustomer();" style="width: 100%;">고객센터</div></li>
        </ul>
    </nav>
    <hr>
   </section>
	
	
	<script>
		
		<%if(loginUser==null){%>
			
			$("a").removeAttr("href").css({"cursor":"pointer","text-decoration":"underline"});
			$("img,span,div").removeEventListener("click").css({"cursor":"pointer"});
			
		<%}else{%>
			$("#sale").click(function(){
				location.href="<%=request.getContextPath()%>/select.cate";
			});
			
			$("#mypage").click(function(){
				location.href="<%=request.getContextPath()%>/views/mypage/pwdInputForm.jsp";	
			});
			$("#customer").click(function(){
				location.href="<%=request.getContextPath()%>/customer_Go";	
			});
			
			
			
			
			$("#message").click(function(){
				window.open("<%=request.getContextPath()%>/recievemsg.me","msgPop","width=500px,height=400px,left=500px,top=200px");
			});
			$("#logout").click(function(){
				location.href="<%=request.getContextPath()%>/logout.me";
			});
				
		
		<%}%>
			
			// 고객센터로 이동
			function gocustomer(){
				location.href="<%=request.getContextPath()%>/customer_Go";
			}
		</script>
</body>

</html>