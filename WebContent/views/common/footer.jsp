<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	footer{

		clear:both;
		 width:1280px; 
		height:100px;
		margin-bottom:0;
		background:#ccffcc;
		box-sizing:border-box;
		position: relative;
	}
	#msgArea{
		width: 80%;
		height: 100%;
		text-align: center;
		position: absolute;
	}
	#imgArea{
		width: 100%;
		height: 30%;
		bottom:0;
	/* 	border:1px solid ; */
		position: absolute;
	}
	#imgArea>img{
		width: 20px;
		height: 20px;
		margin-right: 15px;
		float: right;
	}



</style>
</head>
<body>
	<footer>
		<div id="msgArea">
			<p>COPYRIGHT© 2019 BY YOURS COPYRIGHT COMMISSION. ALL RIGHTS RESERVED.</p>
		</div>
		<div id= imgArea>
			<img alt="" src="<%=request.getContextPath()%>/images/email.png">
			<img alt="" src="<%=request.getContextPath()%>/images/instagram.png">
			<img alt="" src="<%=request.getContextPath()%>/images/facebook.png">
		</div>
	</footer>
</body>
</html>