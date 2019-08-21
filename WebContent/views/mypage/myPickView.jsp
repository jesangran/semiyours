
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="deal.model.vo.Deal"%>
<%@page import="deal.model.vo.DealAttachment"%>
<!DOCTYPE html>
<html>
<head>
<%
ArrayList<Deal> pList = (ArrayList<Deal>)request.getAttribute("pList");
ArrayList<DealAttachment> pfList = (ArrayList<DealAttachment>)request.getAttribute("pfList");

%>

<meta http-equiv="Content-Type" charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../style/member/form.css" type="text/css">

<style>
*{
	box-sizing: border-box;
}

#wrapper{
	float:left;
	width:80%;
	-webkit-overflow-style:none;
}
#wrapper::-webkit-scrollbar{
	display:none;
}
#listFrame {
	
	margin:20px 0 0 100px;
	height: 250px;
	
}
.imgFrame{
	float:left;
	width:200px;
	height:200px;
	margin:5px;
	padding:0;
	border:2px solid lightgrey;
	position :relative;
}
.salImg {
	width: 200px;
	height:200px;
}

ul {
	list-style: none;
	margin:0 ;
	padding: 0;
}
.listSale li {
	float: left;
	top:10px;
	height:240px;
	margin-bottom:20px;
	padding:10px;
	border:1px solid lightgrey;
}
.saleInfo {
	float:left;
	width: 500px;
	height: 100%;
	top:0;
	margin-left:20px ;
	font-size:20px;
	overflow: hidden; 
	white-space: nowrap;
	text-overflow:ellipsis;
	 
}
.cancelBtnArea{
	float:left;
	width: 100px;
	height: 100%;
	line-height: 200px;
	text-align: center;
}
#cancelBtn{
	width:40%;
	height:20%;
	border:0;
	background: white;
	font-size:20px;

}
#cancelBtn:hover{
	cursor:pointer;
	text-decoration: underline;
}
.localSel{cursor:pointer;}


	.dealStatus{
			position: absolute;
			top:0;
			z-index:2;
			font-size:18px;
			text-align:center;
			width:90px;
			height: 25px;
			color:white;
		}
		.soldout{background: red;}
		.selling{background: green;}
		.dealing{background: orange;}

.title,.local,.price{
	height: 33.3%;
	line-height: 70px;
}		

#end{
	clear:both;
}
</style>

</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/myPageSide.jsp"%>

	<section id="wrapper">
		<div id="listFrame">
			<%if(!pList.isEmpty()) {%>
			<ul class="listSale" >
		
					<%for(int i=0; i<pList.size(); i++){ %>
					
						<% if(((Member)session.getAttribute("loginUser"))!=null){%>
 					 	<li class="sale" onclick="location.href='<%=request.getContextPath()%>/detail.de?dealNo=<%=pList.get(i).getDealNo()%>'"> 
						<%}else{ %>
						 <li class="sale" >
						<%} %>
						<div class="imgFrame">
						<img src="<%=request.getContextPath()%>/DealImages/<%=pfList.get(i).getDaChange() %>" class="salImg">
						<%if(pList.get(i).getDealStatus()==1){%>
							<div class="dealStatus selling">판매중</div>
					
						<%}else if(pList.get(i).getDealStatus()==2){%>
							<div class="dealStatus dealing">거래중</div>
						
						<%}else {%>
							<div class="dealStatus soldout">판매완료</div>
						<% }%>
							
						</div>
						
						<div class="saleInfo">
							
							<div class="title">
								<%=pList.get(i).getDealTitle()%>
							</div>
							<div class="price"><%=pList.get(i).getPrice()%>원</div>
							<div class="local"><%=pList.get(i).getDealLocal()%></div>
						</div>
						
					</li>
					
					<li class="cancelBtnArea">
					 		<input type="hidden" value="<%=pList.get(i).getDealNo()%>">
							<button id="cancelBtn">X</button>
					</li>	
					<%} %>
					
			</ul>
			<%}else{ %>
			<h1 align="center">찜한 내역이 없습니다.</h1>
			<%} %>
			
		</div>
		
		<div id="end" style="font-size:15px;" align="center"></div>
		
	</section>
	
	
	<%@ include file="../common/footer.jsp"%>
	<script>
	
	$(function(){
		

	
	$(".pick").css({"font-weight":"bolder","color":"black"});
	
	
	$(".sale").mouseenter(function(){
		
		$(this).children().css({"text-decoration":"underline","cursor":"pointer"});
	}).mouseleave(function(){
		$(this).children().css({"text-decoration":"none","cursor":"none"});
	});
	
	
	var count =8;
	var currentPage =count+1;
	var limit =currentPage+count-1;
	var check=true;
	function goPopup(){
	    var pop = window.open("../mypage/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	}

	function jusoCallBack(roadAddr,addrDetail){
		$("#addr").val(roadAddr);
		$("#addrDetail").val(addrDetail);
	}
	$("#goUpdatePwdFormBtn").click(function(){
		location.href="pwdUpdateForm.jsp";
	});
	
	<%if(pList.size()>=4){%>
	$("#wrapper").css({"overflow":"scroll","height":"800px"});
	$("#wrapper").mouseover(function(){ 
		
		$("#wrapper").scroll(function(){
			 var scrollT = $(this).scrollTop();
		     var scrollH = $(this).height();
			 var contentH = $('#listFrame').height(); 
			 if(scrollT + scrollH +1 >= contentH) {
				if(check==true){
					setTimeout(function(){
					scrollSelectList(limit,currentPage,<%=loginUser.getUserNo()%>);
					},1500);
					 check=false;
				}
					
					
			 }
		})
		
 	}); 
	
<%}%>
	
	
	$("#cancelBtn").click(function(){
		var dNo = $(this).prev().val();
		$.ajax({
			url : "deletePick.my",
			data:{dNo:dNo},
			type:"get",
			success:function(result){
				if(result>0){
					$(".listSale").html("");
					scrollSelectList(8,1,<%=loginUser.getUserNo()%>);
					limit=8;
					currentPage=1;
				}else{
					alert("목록을 삭제하는 도중 오류가 발생했습니다.");
				}
			}
			
		}); 
		
	});
	
	
	
});
	
	

function scrollSelectList(li,curr,uno){
	
	 $.ajax({
	    	
	    	url:"scroll.my",
	    	data:{limit:li,currentPage:curr,uno:uno},
	    	type:"get",
	    	dataType:"json",
	    	success:function(saleList){
	    	
	    		if(saleList.count!=0){
		    		$.each(saleList.pList,function(i){
		    			var src = "<%=request.getContextPath()%>/DealImages/"+saleList.pfList[i];
		    			var onclick = "location.href='<%=request.getContextPath()%>/detail.de?dealNo="+saleList.pList[i].dealNo+"'";
		    			var title = saleList.pList[i].dealTitle;
		    			var price = saleList.pList[i].price;
		    			var local  =saleList.pList[i].dealLocal;
		    			var $salImg = $("<img>");
		    			var $imgFrame=$("<div>");
		    			var $dealStatus=$("<div>");
		    			var $saleInfo=$("<div>");
		    			var $sale = $("<li>");
		    			$salImg.attr({"class":"salImg","src":src});
		    			$imgFrame.html($salImg);
		    			if(saleList.pList[i].dealStatus==1){
		    				 $dealStatus.attr({"class":"dealStatus selling"}).text("판매중");
		    			}else if(saleList.pList[i].dealStatus==2){
		    				 $dealStatus.attr({"class":"dealStatus dealing"}).text("거래중");
		    			}else{
		    				 $dealStatus.attr({"class":"dealStatus soldout"}).text("판매완료");
		    			}
		    			$imgFrame.append($dealStatus);
		    			$imgFrame.attr("class","imgFrame");
		    			$saleInfo.attr("class","saleInfo");
		    			$saleInfo.html("<div class='title'>"+title+"</div><div class='price'>"+price+"원</div><div class='local'>"+local+"</div>");
		    			
		    			$sale.html($imgFrame);
		    			$sale.append($saleInfo);
		    			
		    			
		    			$sale.attr({"class":"sale","onclick":onclick}).mouseenter(function(){
		    				$(this).children().css({"text-decoration":"underline","cursor":"pointer"});
		    			}).mouseleave(function(){
		    				$(this).children().css({"text-decoration":"none","cursor":"none"});
		    			});
		    			
		    			$(".listSale").append($sale);
		    			var $btnList =$("<li>");
		    			var $btn=$("<button>");
		    			$btn.attr("id","cancelBtn");
		    			$btn.css({"font-size":"20px","background":"white","border":"0px"});
		    			$btn.text("X");
		    			$btnList.attr("class","cancelBtnArea");
		    			mouseevent($btn);
		    			$btnList.html($btn);
		    			$(".listSale").append($btnList);
		    		});
		    		
		    		limit=limit+count;
		    		currentPage=currentPage+count;
		    		check=true;
		    		$("#end").text("loading...");
	    		}else{
	    			$("#end").text("더 이상 조회 가능한 물품이 없습니다.");
	    		
	    		}
	    		
	    	}
	    	
	}); 
}

function mouseevent($tag){
	$tag.mouseenter(function(){
		$(this).css({"text-decoration":"underline","cursor":"pointer"});
	}).mouseleave(function(){
		$(this).css({"text-decoration":"none","cursor":"none"});
	});
}	
	
	
	
	</script>
	
	
</body>
</html>