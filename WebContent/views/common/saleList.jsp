<%@page import="deal.model.vo.Local"%>
<%@page import="member.model.vo.Member"%>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="deal.model.vo.DealAttachment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="deal.model.vo.Deal"%>
<%
ArrayList<Deal> dList =(ArrayList<Deal>)request.getAttribute("dList");
ArrayList<DealAttachment> dfList =(ArrayList<DealAttachment>)request.getAttribute("dfList");
String myLocal= (String)request.getAttribute("myLocal");
String keyword= (String)request.getAttribute("keyword");
int dealCount=(Integer)request.getAttribute("dealCount");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
* {
	box-sizing: border-box;
	
}


#wrapper {

	width: 1280px;
	height:1280px;
	scroll-behavior:smooth;
	align-content: center;
	clear: both;
	margin:0;
	-webkit-overflow-style:none;
	background:#F6F6F6;
}
#wrapper::-webkit-scrollbar{
	display:none;
}


#listFrame {
	margin:auto;
	padding:20px 0 0 0;
	height: 100%;
	width: 1040px;
	position: relative;
}
.imgFrame{
	width:250px;
	height:230px;
	margin:0;
	padding:0;
	border:2px solid lightgrey;
	position :relative;
}
.salImg {
	width: 100%;
	height:100%;
}

ul {
	list-style: none;
	margin:0 ;
	padding: 0;
}
.listSale li {
	float: left;
	margin: 0;
	padding: 0;
	top:10px;
}
.listFooter {
	width: 250px;
	height: 100px;
	top:0;
	margin: 0;
	font-size:18px;
	overflow: hidden; 
	white-space: nowrap;
	text-overflow:ellipsis;
	 
}


.localSel{cursor:pointer;}


/* -----------------------지역선택--------------------------- */

     .menubar{
            margin:0px;
            padding:0px;
            font: 67.5% "Lucida Sans Unicode", "Bitstream Vera Sans", "Trebuchet Unicode MS", "Lucida Grande", Verdana, Helvetica, sans-serif;
            font-size:14px;
            font-weight:bolder;
            height:50px;
             width:1000px;
              margin:auto;
            }

            .highList{
             width:100%;
            height:100%;
            list-style:none;
            padding:0;
            }
			.localSel{
				float:left;
	            display: inline-block;
	            width:220px;
	            height: 50px;
	            line-height:50px;
	            text-align: center;
	            font-size:20px;
	            
			}
            
			
           

            .localList{
            background: whitesmoke;
            display:none; /* 평상시에는 드랍메뉴가 안보이게 하기 */
            width:700px;
            opacity: 0.8;
            position: absolute;
            }

            .menubar li:hover ul{display: inline; /* 마우스 커서 올리면 드랍메뉴 보이게 하기 */}

            .menubar li li {
            display: inline;
            float:none;
            margin:0px;
            padding:0px;
            }

            

           

         
		
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
		#end{clear:both;}
		.noSale{
			padding:0;
			margin:0;
			position: absolute;
			top:20px;
			left: 360px;
		}
		
		#searchResult{
			width:1000px;
			margin:auto;
			margin-bottom:30px;
			font-weight: bolder;
		}
</style>
</head>
<body>






<%if(!dList.isEmpty()){
	if(dList.get(0).getDept1()!=null){
%>
<span><%=dList.get(0).getDept1() %></span>>><span><%=dList.get(0).getDept2() %></span>
<%} 
	}%>
		
		
	<%-- 	<%if(keyword!=null){%>
		<div id="searchResult">
			<p>총 <%=dealCount%> 건이 검색 되었습니다.</p>
		
		</div>
		<%} %> --%>
 <div class= menubar>
        <ul class="highList">
        
            <li><span class="localSel local" id="local">우리동네</span></li>
            <li><span class="localSel public" id="public">전국</span>
 
            </li>
        </ul>
    </div>
	
	<section id="wrapper">
		
		
		<div id="listFrame">
			<%if(!dList.isEmpty()) {%>
			
			<ul class="listSale" >
		
					<%for(int i=0; i<dList.size(); i++){ %>
					
						<% if(((Member)session.getAttribute("loginUser"))!=null){%>
 					 <li class="sale" onclick="location.href='<%=request.getContextPath()%>/detail.de?dealNo=<%=dList.get(i).getDealNo()%>'"> 
						<%}else{ %>
						 <li class="sale" >
						<%} %>
						<div class="imgFrame">
						<img src="<%=request.getContextPath()%>/DealImages/<%=dfList.get(i).getDaChange() %>" class="salImg">
						<%if(dList.get(i).getDealStatus()==1){%>
							<div class="dealStatus selling">판매중</div>
					
						<%}else if(dList.get(i).getDealStatus()==2){%>
							<div class="dealStatus dealing">거래중</div>
						
						<%}else {%>
							<div class="dealStatus soldout">판매완료</div>
						<% }%>
							
						</div>
						
						<div class="listFooter">
							
							<div>
								<%=dList.get(i).getDealTitle()%>
							</div>
							<div><%=dList.get(i).getPrice()%>원</div>
							<div><%=dList.get(i).getDealLocal().split(" ")[0]+" "+dList.get(i).getDealLocal().split(" ")[1]%></div>
						</div>
							
					</li>
					<%} %>
					
			</ul>
			<%}else{ %>
			<h1 class="noSale" align="center">등록된 물품이 없습니다 ㅠㅠ</h1>
			<%} %>
			
		</div>
		
		<div id="end" style="font-size:15px;" align="center"></div>
	</section>
	
	
	
	
	<script>
	var count =24;
	var currentPage =count+1;
	var limit =currentPage+count-1;
	var check = true;
	var local="<%=myLocal%>";

	

	$(function(){
		
		$("#public").click(function(){
			$(this).css("background","#F6F6F6");
			$("#local").css("background","");
			currentPage=1;
			limit=24;
			local="";
			$(".listSale").html("");
			scrollSelectList(limit,currentPage,local);
		});
		$("#local").click(function(){
			$(this).css("background","#F6F6F6");
			$("#public").css("background","");
			currentPage=1;
			limit=24;
			local="<%=myLocal%>";
			$(".listSale").html("");
			scrollSelectList(limit,currentPage,local);
		})
		
		
		
		$(".listSale>li").mouseenter(function(){
			
			$(this).children().css({"text-decoration":"underline","cursor":"pointer"});
		}).mouseleave(function(){
			$(this).children().css({"text-decoration":"none","cursor":"none"});
		});
				
				$("#wrapper").mouseover(function(){ 
					$("#wrapper").scroll(function(){
						 var scrollT = $(this).scrollTop();
     					 var scrollH = $(this).height();
        				 var contentH = $('#listFrame').height(); 
       					 if(scrollT + scrollH +1 >= contentH) {
							if(check){
						
							setTimeout(function(){
								 scrollSelectList(limit,currentPage,local);
								},1500);
								check=false;
							}
						}
					});
			 	}).css({"overflow":"scroll","height":"1280px"}); 
		
		});
		
		
		
		function scrollSelectList(li,curr,local){
			
			 $.ajax({
			    	
			    	url:"scroll.de",
			    	data:{limit:li,currentPage:curr,local:local},
			    	type:"get",
			    	dataType:"json",
			    	success:function(saleList){
			    		if(saleList.count!=0){
				    		$.each(saleList.dList,function(i){
				    			var src = "<%=request.getContextPath()%>/DealImages/"+saleList.dfList[i];
				    			var onclick = "location.href='<%=request.getContextPath()%>/detail.de?dealNo="+saleList.dList[i].dealNo+"'";
				    			var title = saleList.dList[i].dealTitle;
				    			var price = saleList.dList[i].price;
				    			var local  =saleList.dList[i].dealLocal;
				    			var $salImg = $("<img>");
				    			var $imgFrame=$("<div>");
				    			var $dealStatus=$("<div>");
				    			var $listFooter=$("<div>");
				    			var $sale = $("<li>");
				    			$salImg.attr({"class":"salImg","src":src});
				    			$imgFrame.html($salImg);
				    			if(saleList.dList[i].dealStatus==1){
				    				 $dealStatus.attr({"class":"dealStatus selling"}).text("판매중");
				    			}else if(saleList.dList[i].dealStatus==2){
				    				 $dealStatus.attr({"class":"dealStatus dealing"}).text("거래중");
				    			}else{
				    				 $dealStatus.attr({"class":"dealStatus soldout"}).text("판매완료");
				    			}
				    			$imgFrame.append($dealStatus);
				    			$imgFrame.attr("class","imgFrame");
				    			$listFooter.attr("class","listFooter");
				    			$listFooter.html("<div>"+title+"</div><div>"+price+"원</div><div>"+local+"</div>");
				    			
				    			$sale.html($imgFrame);
				    			$sale.append($listFooter);
				    			$sale.attr({"class":"sale","onclick":onclick}).mouseenter(function(){
				    				$(this).children().css({"text-decoration":"underline","cursor":"pointer"});
				    			}).mouseleave(function(){
				    				$(this).children().css({"text-decoration":"none","cursor":"none"});
				    			});;
				    			$(".listSale").append($sale);
				    			
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
		
		
	
	</script>
</body>
</html>