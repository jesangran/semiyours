<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="deal.model.vo.Category1"%>
<%@page import="java.util.ArrayList"%>
<%
/* ArrayList<Category1> c1List = (ArrayList<Category1>)request.getAttribute("c1List"); */
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
<form id="dealInsertForm" method='post' action="<%=request.getContextPath()%>/insert.de" enctype="multipart/form-data">

<div class="outer">

    <div class="imgarea">
        <br>
        
        <input type="file" id="inputImg1" name="inputImg1" onchange="loadImg(this,1)">
        <input type="file" id="inputImg2" name="inputImg2" onchange="loadImg(this,2)">
        <input type="file" id="inputImg3" name="inputImg3" onchange="loadImg(this,3)">
        <input type="file" id="inputImg4" name="inputImg4" onchange="loadImg(this,4)">
        <div id="bigimg">
            <img id="dealImg" >
        </div>
        <div class="simgarea">
            <div onclick="inputImg(1)"><img id="dImg1" required="required"></div>
            <div onclick="inputImg(2)"><img id="dImg2"></div>
            <div onclick="inputImg(3)"><img id="dImg3"></div>
            <div onclick="inputImg(4)"><img id="dImg4"></div>
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
                                <option selected value="0">선택</option>
                                <%for(Category1 c1 : c1List){ %>
								 <option value="<%=c1.getcNo()%>"><%=c1.getcName() %></option>		
								<%} %>                           
                            </select>                   
                            <select id="dept2" name="dept2" required="required">
                              <option   selected value="000">선택</option>
                            
                            </select>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="title">제목</td>
                        <td><input type="text" id="dealTitle" name="dealTitle" style="width: 70%" required="required"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="title">거래방식</td>
                        <td>
                        <label for="dealtype">직거래</label>
                        <input type="radio" name="dealType" value="1" required="required">
                        <label for="dealtype">안전거래</label>
                        <input type="radio" name="dealType" value="2" required="required">
                        </td> 
                    </tr>
                    <tr>
                        <td class="title">금액</td>
                        <td><input type="text" id="price" name="price" style="width: 30%" required="required">&nbsp;원</td>
                    </tr>
                    <tr>
                        <td class="title">수량</td>
                        <td><input type="number" id="count" name="dealCount" value="1" min=1  style="width: 30%" required="required"></td>
                    </tr>
                    <tr>
                        <td class="title">거래위치</td>
                        <td>
                        <input type="text" id="dealLocal" name="dealLocal" size="70" required="required">
                        <input type="hidden" id="localDetail">
                        <input type="button" value="위치검색" onclick="goPopup()">       
                        <div id = map style ="width:400px; height:250px;"></div>
                        </td>
                    </tr>
                    <tr>
                        <td class="title">상세내용</td>
                        <td>
                            <textarea  id="dealContent" name="dealContent" cols="60" rows="10" maxlength="200" style="resize: none" placeholder="당신의 물건을 소개해주세요. 최대 200자"></textarea>
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

function goPopup(){
    var pop = window.open("<%=request.getContextPath()%>/views/mypage/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadAddr,addrDetail){
	$("#dealLocal").val(roadAddr);
	addressChk(roadAddr,addrDetail);
}

$("#dept1").change(function(){
		var cno = $("#dept1").val();
		if(cno!="0"){
			$.ajax({
				url:"select2.cate",
				data:{cno:cno},
				type:"get",
				dataType:"json",
				success:function(result){
							
					var $select=$("#dept2").html("<option selected>선택</option>");
					$.each(result,function(i){
					$option = $("<option value='"+result[i].cNo+"'>");
					$option.text(result[i].cName);
					$select.append($option);
					});
						
				}
			});
		}else{
			$("#dept2").html("<option selected>선택</option>");
		}
	
	
});
$("input:file").hide();
$(".simgarea div>img").hide();

function inputImg(num){
	$("#inputImg"+num).click();
}



function loadImg(value,num){
	var reader = new FileReader(); // 함수실행시 객체 생성
	// reader.onload : reader 객체가 생성된 경우 이벤트 발생
	reader.onload = function(e){ //객체 뒤에 onload: 객체가 생성되자마자, 객체 생성시 발생하는 이벤트// e: 이벤트객체 
		$("#dealImg").attr("src", e.target.result); // attr= 속성 추가 메서드 /e.target =this와 같음/ 위에있는input태그의 file을 나타냄.
		
		$("#dImg"+num).attr("src", e.target.result).show();
	}
	// 보안처리(Data URI)
	// RFC 2397정의 되어있는 개발 규약 -> 안적으면 파일 경로 그대로 나옴 .
	
	// 파일에 직접적인 경로 노출 방지
	reader.readAsDataURL(value.files[0]);
}
$("#dealInsertForm").submit(function(){
	if($("#inputImg1").val()=""){
		return false;
	}
});
	




</script>

<script>
var address=document.getElementById("dealLocal");
var mapContainer = document.getElementById("map");
var coordXY   = document.getElementById("coordXY");
var mapOption;
var map;
var x,y  = "";

if (address.value=="") {

 mapOption = {
  center: new kakao.maps.LatLng(37.568168, 126.983014), // 임의의 지도 중심좌표 , 제주도 다음본사로 잡아봤다.
  level: 4// 지도의 확대 레벨

 };
}

// 지도 생성


map = new kakao.maps.Map(mapContainer, mapOption);

function addressChk(local,detail) {
$("#localDetail").val(detail);
map = new kakao.maps.Map(mapContainer, mapOption);
 var gap = local; // 주소검색어
 if (gap=="") {
  alert("주소 검색어를 입력해 주십시오.");
  address.focus();
  return;
 }
 
 
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
   if(detail!=""){
	    var infowindow = new kakao.maps.InfoWindow({
	    content: '<div style="width:150px;text-align:center;padding:5px 0;">'+detail+'</div>'
	   });
	
	   infowindow.open(map,marker); 
   }
   
   // 지도 중심을 이동
   map.setCenter(coords);

 
  }
 });
}
</script>
</body>
</html>