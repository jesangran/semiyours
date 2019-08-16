<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	nav{
		border:2px solid red;
		background-color:blanchedalmond;
	    color: darkgreen;
	    width: 1280px;
        height:200px;
	    clear: both;
	    position: relative;
	}
	nav>ul>li{
		border:1px solid red;
		background-color:aqua;
        border-radius:40px;
	    float: right;
	    list-style: none;
	    width: 100px;
	    height: 50px;
	}
	nav>ul>li:hover{
		
		background-color:yellow;
        border-radius:40px;
	    float: right;
	    list-style: none;
	    width: 100px;
	    height: 50px;

	    
	}
	nav>ul>li>a{
	    text-decoration: none;
	    font-size: 13px;
	    color: darkgreen;
	    /* line-height: 60px; */
	}
	
</style>
</head>
<body>
	<header>
    <nav>
        <ul align="center">    
            <li><a href="#"><h2>공지사항</h2></a></li>
            <li><a href="#"><h2>이용약관</h2></a></li>
            <li><a href="#"><h2>문의하기</h2></a></li>
            <li><a href="#" onclick="notice_go"><h2>FAQ</h2></a></li>
       
        </ul>
    </nav>
   <script>
   function notice_go(){
  		location.href="<%=request.getContextPath()%>/ServiceCenter_Go";
  	}
   function notice_go(){
  		location.href="<%=request.getContextPath()%>/ServiceCenter_Go";
  	}
   function notice_go(){
  		location.href="<%=request.getContextPath()%>/ServiceCenter_Go";
  	}
   	function notice_go(){
   		location.href="<%=request.getContextPath()%>/ServiceCenter_Go";
   	}
   </script>
</body>
</html>