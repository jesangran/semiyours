<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
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

        #bigimg{
            height: 75%;
            width: 99%;
            border: 0.5px solid darkgray;
            margin-bottom: 5px; 
        }
        .simgarea{
            height: 25%;
            width: 100%;
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
            height: 80%;
            margin-top: 10px; 
        }
        .title{
            width: 12%;
           
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
    </style>
    </head>
<body>

<%@ include file="../../views/common/header.jsp"%>
<div class="outer">
    <span>카테고리1</span> > <span>카테고리2</span>
   <h2 align="left" style="font-size: 20px">&nbsp;등록된 정보</h2>
	     
	    <div class="imgarea">
	        
	        <div id="bigimg">
	            <img src="" alt="">
	        </div>
	        <div class="simgarea">
	            <div><img src="" alt=""></div>
	            <div><img src="" alt=""></div>
	            <div><img src="" alt=""></div>
	            <div><img src="" alt=""></div>
	        </div>
	       
	
	    </div>
	  
	    <div class="frmarea" style = "margin-bottom: 50px;">
	            <div id ="tablearea"> 
	              
	               
	                <table>
	  
	                    <tr>
	                        <td class="title" "font-size: 20px;">제목</td>
	                        <td colspan=3>
	                        	제목명
							</td>
	                     
	                    </tr>
	                    <tr>
	                        <td class="title">거래방식</td>
	                       <td colspan=3>
	                    </tr>
	                    <tr>
	                        <td class="title">금액</td>
	                        <td>10000 원</td>
	                    </tr>
	                    <tr>
	                        <td class="title">수량</td>
	                        <td>1 개</td>
	                    </tr>
	                    <tr>
	                         <td class="title" "font-size: 30px;">거래위치</td> 
	                        <!-- <input type="button" value="위치찾기" id="findlocation" > -->
	                        <td >경기도 </td>
	                    </tr>
	                     <tr>
	                        <td class="title">지도</td>
	                        <td colspan=3>
	                            <div class="roadArea">
	                            
	                            </div>
	                            
	                        </td>
	                        
	                    </tr>                 
	                    
	                        
	                                     
	             
	                </table>
	                
	    	</div>
	    	
	    	
	    	
	    	
	    
	            </div>	    
	    	<h2 class="deatailh2">상세내용</h2>
	                <div class="contentArea">
	                            
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
    
    
  <!--   <div class="replyListArea">
  
   		<table id="replyListTable" align = "center" >
      
     	</table>
    </div>
     -->
</div>

<script>

</script>
<br style="clear:both">
<%@ include file="../../views/common/footer.jsp"%>
</body>
</html>