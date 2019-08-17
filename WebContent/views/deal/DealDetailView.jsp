<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="deal.model.vo.Deal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="deal.model.vo.DealAttachment"%>
<%
Deal deal = (Deal)request.getAttribute("deal"); 
ArrayList<DealAttachment> daList =(ArrayList<DealAttachment> )request.getAttribute("daList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=032cefe9c29d59485ed638e69d2033e6&libraries=services,clusterer"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=032cefe9c29d59485ed638e69d2033e6"></script>
 
    <style>
        
        *{
            box-sizing: border-box;
            font-family:'Malgun Gothic';
            font-size: 12px;
        }
        .outer{
            width: 1280px;
            margin: auto;
        }
      
        .imgarea {
            margin-top: auto;
            width: 50%;
            height: 500px;
            float: left;
            /*  border: solid black; */

           /*  border-right: 0.5px solid darkgreen; */
        }
        .frmarea{
            width: 50%;
            height: 70%;
            float: left;
            /* border: solid black; */
            margin: auto;
            padding: auto;

        }
        .replyInputArea{
            width: 100%;
            height: 30%;
        
            
        }

        .replyListArea {
        	width: 70%;
        	margin: auto;
        }
        
        #inputimg{
            height: 9%;
            width: 99%;
            margin-bottom: 1px;
            border: 0.5px solid darkgreen;
        }

        #bigimgarea{
            height: 75%;
            width: 99%;
            border: 0.5px solid darkgray;
            margin-bottom: 5px; 
            text-align: center;
        }
        .bigimg{
        	width:80%;
        	height:100%;
        	
        }
        .simgarea{
            height: 25%;
            width: 100%;
       }
       .smallimg{
    		width:100%;
    		height:100%;
    	}
    	.smallimg:hover{
    		cursor:pointer;
    	}
    	
       .simgarea div{
           width: 24%;
           height: 99%;
           margin:0.5%;
 		   border: 0.5px solid darkgray;
           float:left;
       }
       
        #dealInsertFrm{
            width: 100%;
            height: 100%;
            
            padding: 0;
            
        }
        #tablearea{
            width: 100%;
            height: 90%;
            margin-left: 10px;
         
        }
       
        table{
            
            width: 100%;
            margin-top: 10px; 
       
        }
        
		
		td{
			padding:10px;
		}
        .title{
            width: 20%;
            font-size:16px;
           
        }
        .dealInfo{
        	font-size:16px;
        }
        #cancel, #submit{
            margin: 15px;
        }       
        .replyInputArea table{
        	width : 70%
        }
        
        .replyListArea tr>td:nth-child(1) {
        	width: 73px;
        }
        input[type=text]{
        	border:0;
        }
        
        .contentArea{
         
        	border:1px solid rgba(0,0,0,0.3);
        	width:100%;
        	height:400px;
        	
        }
        .titleArea>h2{
        	padding:0;
        	margin:0;
        }
        .commentArea{
       
        font-size:18px;
        padding:15px;
        }
    	.roadArea{
    	border:1px solid rgba(0,0,0,0.3);
    		width:100%;
        	height:300px;
    	}
    	.deatailh2{
    		padding:20px 0 0 0;
    		font-size:20px;
    		clear:both;
    	}
    	#safeDealBtn{
    	
    		width:300px;
    		height:50px;
    	}
    	
    	#dealTitle{
    		width:80%;
    		float:left;
    		font-size:20px;
    		
    	}
    	#icon{
    	
    		float:right;
    		width:20%;
    		text-align: right;
    		
    	}
    	
    	#titleArea{
    		margin:10px;	
    		width:100%;
    		height: 40px;
    		border-bottom:1px solid lightgrey;
    	}
    </style>
    </head>
<body >

<%@ include file="../../views/common/header.jsp"%>
    <div class="outer">
   
   <div id="titleArea">
	   <div id="dealTitle">
	   &nbsp;<%=deal.getDealTitle() %> 
	   </div>
	   
	   <div id="icon">
	    <span id="eye"> <img src="<%=request.getContextPath() %>/images/eye.png" >&nbsp;&nbsp;&nbsp;<%=deal.getViewCount()%></span> 
	  &nbsp;&nbsp;&nbsp;&nbsp;
	      <span id="report"><img width=20px height=20px  src="<%=request.getContextPath() %>/images/warning.png" ></span>
	  </div>
	     
  	   </div>
	
 </div>
	
	    <div class="imgarea">
	        
	        <div id="bigimgarea">
	            <img  class="bigimg" src="<%=request.getContextPath() %>/DealImages/<%=daList.get(0).getDaChange()%>" alt="">
	        </div>
	        <div class="simgarea">
	        <%for(DealAttachment da : daList){ %>
	            <div><img class="smallimg" id="smallimg<%=daList.indexOf(da)+1%>" src="<%=request.getContextPath() %>/DealImages/<%=da.getDaChange()%>"></div>
		    <%} %>
	        </div>
	       
	
	    </div>
	  
	    <div class="frmarea" style = "margin-bottom: 50px;">
	            <div id ="tablearea"> 
	              
	               
	                <table >
	  					<tr>
	                        <td class="title">판매자</td>
	                        
	                       <td class="dealInfo" id="seller"  colspan=3 >
	                    		<%=deal.getDealWirter() %>
	                       </td>
	                       
	                    </tr>
	                  	<tr>
	                  	<td class="title">카테고리 </td>
	                  	<td colspan=3  class="dealInfo"> <span><%=deal.getDept1() %></span> > <span><%=deal.getDept2() %></span></td>
	                  	</tr>
	                    <tr>
	                        <td class="title">거래방식</td>
	                        
	                       <td class="dealInfo" colspan=3>
	                       <%if(deal.getDealType()==1){ %>
	                       		직거래
	                       <%}else{ %>
	                       		<img src="<%=request.getContextPath()%>/images/naverpay.png" id="safeDealBtn">
	                       <%} %>	
	                       </td>
	                    </tr>
	                    <tr>
	                        <td class="title">금액</td>
	                        <td class="dealInfo"><%=deal.getPrice() %> 원</td>
	                    </tr>
	                    <tr>
	                        <td class="title">수량</td>
	                        <td class="dealInfo"><%=deal.getDealCount()%>개</td>
	                    </tr>
	                    <tr>
	                         <td class="title" >거래위치</td> 
	                        <td class="dealInfo" id="dealLocal"><%=deal.getDealLocal()%></td>
	                    </tr>
	                     <tr>
	                        <td class="title">지도</td>
	                        <td class="dealInfo" colspan=3>
	                            <div id="map" class="roadArea" >
	                            
	                            </div>
	                            
	                        </td>
	                        
	                    </tr>                 
	                    
	                        
	                                     
	             
	                </table>
	                
	    	</div>
	    	
	    	
	    	
	    	
	    
	            </div>	    
	    			<h2 class="deatailh2">상세내용</h2>
	                <div class="contentArea">
	                     <%=deal.getDealContent() %> 
	               </div>
	         
	               
	    <!------------------------------------------- 댓글작성 ------------------------------------------->
     <h3 class="commentArea"><span>댓글</span>(<span>0</span>)</h3>
    	<hr>
    <div class="replyInputArea">
   
       <table id="replyInputTable" align = "center">
            <tr>
                <td id="title">댓글입력</td>
                <td><textarea id="replyContent" cols="120" rows="3"></textarea></td>
                <td><button type="submit">등록</button></td>
            </tr>
        </table>
    </div> 
    
    



<script>
	$(function(){
		$("#smallimg1").css("border","3px solid green");		
		$(".smallimg").click(function(){
			$(".bigimg").attr("src",$(this).attr("src"));
			$(".smallimg").css("border","");
		
			$(this).css("border","3px solid green");
			
		});
		
		$("$seller").click()
	
	});
	
	
	
	$("#report").click(function(){
		window.open("insertForm.re?no=<%=deal.getDealNo()%>&rType=<%=deal.getrType()%>",
				"reportpop","width=400px,height=200px,left=800px,top=300px, scrollbars=yes, resizable=yes"); 
	});
	
	
	
</script>


<br style="clear:both">
<%@ include file="../../views/common/footer.jsp"%>



<script>

var mapContainer = document.getElementById("map");
var coordXY   = document.getElementById("coordXY");
var mapOption;
var map;
var x,y  = "";




 mapOption = {
  center: new kakao.maps.LatLng(37.568168, 126.983014), // 임의의 지도 중심좌표 , 제주도 다음본사로 잡아봤다.
  level: 4// 지도의 확대 레벨

 };


// 지도 생성


map = new kakao.maps.Map(mapContainer, mapOption);
 
$(function(){
 var gap = "<%=deal.getDealLocal()%>"; // 주소검색어
 
 
 
 // 주소-좌표 변환 객체를 생성
 var geocoder = new kakao.maps.services.Geocoder();

 // 주소로 좌표를 검색
 geocoder.addressSearch(gap, function(result, status) {
  
  // 정상적으로 검색이 완료됐으면,
  if (status == kakao.maps.services.Status.OK) {
   
	var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

   y = result[0].x;
   x = result[0].y;

   // 결과값으로 받은 위치를 마커로 표시
   
   var marker = new kakao.maps.Marker({
    map: map,
    position: coords
   });


   // 인포윈도우로 장소에 대한 설명표시
  
	    var infowindow = new kakao.maps.InfoWindow({
	    content: '<div style="width:150px;text-align:center;padding:5px 0;"></div>'
	   });
	
	   infowindow.open(map,marker); 
  
   
   // 지도 중심을 이동
   map.setCenter(coords);

 
  }
 });
}); 
</script>


</body>
</html>