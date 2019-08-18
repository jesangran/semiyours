<%@page import="deal.model.vo.Category2"%>
<%@page import="deal.model.vo.Deal"%>
<%@page import="deal.model.vo.DealAttachment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="deal.model.vo.Category1"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<Category1> cList = (ArrayList<Category1>)request.getAttribute("c1List");
ArrayList<Category2> c2List = (ArrayList<Category2>)request.getAttribute("c2List");
ArrayList<DealAttachment> file=(ArrayList<DealAttachment>)request.getAttribute("file");
Deal deal = (Deal)request.getAttribute("deal");
deal.setDealContent(deal.getDealContent().replace("<br>", ""));
%> 
<!DOCTYPE html>
<html lang="ko">
    <head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=032cefe9c29d59485ed638e69d2033e6&libraries=services,clusterer"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=032cefe9c29d59485ed638e69d2033e6"></script>

<style>
* {
	box-sizing: border-box;
	
}

.outer {
	width: 1280px;
	height: 1000px;
	margin: auto;
}

.imgarea {
	width: 50%;
	height: 100%;
	float: left;
	/* border: solid black; */
	position: relative;
	/*  border-right: 0.5px solid darkgreen; */
}

.frmarea {
	width: 50%;
	height: 100%;
	float: left;
	/* border: solid black; */
	margin: auto;
}

#inputimg {
	height: 9%;
	width: 99%;
	margin-bottom: 1px;
	border: 0.5px solid darkgreen;
}

#bigimg {
	height: 50%;
	width: 100%;
	border: 0.5px solid darkgray;
	margin-bottom: 5px;
	text-align: center;
}
#dealImg{
	width:80%;
	height:80%;
	margin-top:10%;
}
.simgarea {
	height: 15%;
	width: 100%;
}

.simgarea div {
	width: 155px;
	height: 100%;
	border: 0.5px solid darkgray;
	margin: 2.5px;
	float: left;

	 
	
}
.simgarea div>img{
	width:100%;
	height:100%;
	
}
#alertmsg {
	height: 20%;
	border: 0.5px solid darkgreen;
	margin: 5px;
}

#alertmsg>p {
	padding: 5px;
}

#dealInsertFrm {
	width: 100%;
	height: 100%;
	padding: 0;
}

#tablearea {
	width: 100%;
	height: 90%;
	margin-left: 10px;
}

table {
	/* border: 1px solid black; */
	width: 100%;
	height: 80%;
	margin-top: 10px;
}

.title {
	width: 12%;
	/* border: 1px solid */
}

#cancel, #submit {
	margin: 15px;
}
</style>

</head>
<body>
<%@ include file="../../views/common/header.jsp"%>
<form id="dealInsertForm" method='post' action="<%=request.getContextPath()%>/update.de" enctype="multipart/form-data">
<input type="hidden" name="dealNo" value="<%=deal.getDealNo()%>">
<div class="outer">

    <div class="imgarea">
        <br>
         <input type="file" id="inputImg1" name="inputImg1" onchange="loadImg(this,1)"> 
         <input type="file" id="inputImg2" name="inputImg2" onchange="loadImg(this,2)">
         <input type="file" id="inputImg3" name="inputImg3" onchange="loadImg(this,3)">
         <input type="file" id="inputImg4" name="inputImg4" onchange="loadImg(this,4)"> 
         <input id="fileCheck" name="" type="hidden" value="0">
        <div id="bigimg">
           <img id="dealImg" src="<%=request.getContextPath()%>/DealImages/<%=file.get(0).getDaChange()%>" >
        </div>
        <div class="simgarea">
         <%for(int i=0; i<file.size(); i++){ %>
            <div onclick="inputImg(<%=i+1%>)"><img id="dImg<%=i+1%>" src="<%=request.getContextPath()%>/DealImages/<%=file.get(i).getDaChange()%>"></div>
         <%} %>
         <%for(int i=file.size(); i<4; i++){ %>
         	 <div onclick="inputImg(<%=i+1%>)"><img id="dImg<%=i+1%>"></div>
         <%} %>
        </div>
        <div id="alertmsg">
            <p>
                 * 상품 이미지는 640x640에 최적화 되어 있습니다. <br>
                - 이미지는 상품등록 시 정사각형으로 짤려서 등록됩니다. <br>
                - 확대하기를 누를 경우 원본이미지를 확인할 수 있습니다. <br>
                - 큰 이미지일경우 이미지가 깨지는 경우가 발생할 수 있습니다. <br>
            </p>
        </div>

    </div>
    <div class="frmarea">
            <div id ="tablearea"> 
                <h2 align="left" style="font-size: 20px">&nbsp;물건등록</h2>
                <hr>
              
          
                <table>
                    <tr>
                        <td class="title">카테고리</td>
                        <td>
                            <select id="dept1" name="dept1" required="required">
                            <%for(int i=0; i<cList.size(); i++){ 
                            	if(deal.getDept1().equals(cList.get(i).getcName())){%>
                              <option id="selected1" selected value="<%=cList.get(i).getcNo()%>"><%=cList.get(i).getcName()%></option>
                            <%}else{%>
                            	<option  value="<%=cList.get(i).getcNo()%>"><%=cList.get(i).getcName()%></option>
                            <%}}%>
                            </select>      
                                         
                            <select id="dept2" name="dept2" required="required">
                            	<%for(int i=0; i<c2List.size(); i++){ 
                            		if(deal.getDept2().equals(c2List.get(i).getcName())){%>
                              			<option id="selected2" selected value="<%=c2List.get(i).getcNo()%>"><%=c2List.get(i).getcName()%></option>
                           			<%}else{%>
                            			<option  value="<%=c2List.get(i).getcNo()%>"><%=c2List.get(i).getcName()%></option>
                            	<%}}%>
                            </select>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="title">제목</td>
                        <td><input type="text" id="dealTitle"  name="dealTitle" value="<%=deal.getDealTitle() %>" style="width: 70%" required="required"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="title">거래방식</td>
                        <td>
                        <label for="dealtype">직거래</label>
                        <input type="radio"  name="dealType" class="dealType type1" value="1" required="required">
                        <label for="dealtype">안전거래</label>
                        <input type="radio" name="dealType" class="dealType type2" value="2" required="required">
                        </td> 
                    </tr>
                    <tr>
                        <td class="title">금액</td>
                        <td><input type="text" id="price" name="price" value="<%=deal.getPrice() %>" style="width: 30%" required="required">&nbsp;원</td>
                    </tr>
                    <tr>
                        <td class="title">수량</td>
                        <td><input type="number" id="count" name="dealCount" value="<%=deal.getDealCount()%>" min=1  style="width: 30%" required="required"></td>
                    </tr>
                    <tr>
                        <td class="title">거래위치</td>
                        <td>
                        <input type="text" id="dealLocal" name="dealLocal" value="<%=deal.getDealLocal()%>" size="50" required readonly>
                        <input type="hidden" id="localDetail" >
                        <input type="button" value="위치검색" onclick="goPopup()">       
                        <div id = map style ="width:400px; height:250px;"></div>
                        </td>
                    </tr>
                    <tr>
                        <td class="title">상세내용</td>
                        <td>
                            <textarea  id="dealContent" name="dealContent" cols="60" rows="10" maxlength="200" 
                            style="resize: none" >
                            	<%=deal.getDealContent()%>
                            
                            </textarea>
                        </td>
                        <td></td>
                    </tr>                 
                    <tr>
                        <td></td>
                        <td><button type="reset" id="cacel">등록취소</button>&nbsp;
                        <button type="submit" id="submit">물건등록</button></td>       
                    </tr>
                </table>
       
           </div>
    </div>
</div>
</form>
<%@ include file="../../views/common/footer.jsp"%>

<script>


$(function(){
	
	
	/* var selectedOption = $("#selected1").val();

	selectCate2(selectedOption); */
	
	$("#dept1").change(function(){
		var cno = $("#dept1").val();
		$("#dept2").html("");
		selectCate2(cno);	
	});
	
	//$("input:file").hide();
	
	$("#dealInsertForm").submit(function(){
		if($("#inputImg1").val()==""){
			$("#dealInsertForm").attr("enctype",false);
			$("#de("#fileCheck").val("1");
			
		}
	});
	
	if(Number($(".type1").val())==<%=deal.getDealType()%>){
		$(".type1").attr("checked","checked");
	}else{
		$(".type2").attr("checked","checked");
		
	}
	$("#inputImg1").val($("#file1").val());
		
	
});


function inputImg(num){
	$("#inputImg"+num).click();
}

function loadImg(value,num){
	var reader = new FileReader(); 
	reader.onload = function(e){ 
		$("#dealImg").attr("src", e.target.result); 
		
		$("#dImg"+num).attr("src", e.target.result).show();
	}
	reader.readAsDataURL(value.files[0]);
}

function selectCate2(cno){
	if(cno!="000"){
		   $.ajax({
			url:"select2.cate",
			data:{cno:cno},
			type:"get",
			dataType:"json",
			success:function(result){
						
				var $select=$("#dept2");
				$.each(result,function(i){
				$option = $("<option value='"+result[i].cNo+"'>");
				$option.text(result[i].cName);
					if($option.text()!=$select.children().eq(0).text()){
						$select.append($option);
					}
				});
					
			}
		});
	}
	else{
		$("#dept2").html("<option selected>선택</option>");
	}	   
		   
}

function goPopup(){
    var pop = window.open("<%=request.getContextPath()%>/views/mypage/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadAddr,addrDetail){
	$("#dealLocal").val(roadAddr);
	searchMap(roadAddr);
}

</script>

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
 searchMap(gap);
}); 



function searchMap(gap){
	 var geocoder = new kakao.maps.services.Geocoder();
	 geocoder.addressSearch(gap, function(result, status) {
	  if (status == kakao.maps.services.Status.OK) {
		var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	   y = result[0].x;
	   x = result[0].y;
	   var marker = new kakao.maps.Marker({
	    map: map,
	    position: coords
	   });
	   map.setCenter(coords);
	  }
	 });
}

</script>
</body>
</html>