<%@page import="deal.model.vo.Deal"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String nickname = (String)request.getAttribute("nickname");
 	int mOwner = (Integer)request.getAttribute("mOwner"); 
 %>
<!DOCTYPE html>
<html lang="ko">
    <head>
    <meta charset="UTF-8">
        <title> </title>
        <style>
            .outer{
                width: 500px;
                height: 300px;
            }
            table{
				border: 1px solid #333;
				border-collapse: collapse;
                width: 100%;
                height: 100%;
                padding: 0;
                margin: 0;
			}
            tr{
                border-bottom: 1px solid #333;
            }
            td{
                border-right: 1px solid #333;
            }
            #label{
                text-align: center;
                background-color: #3ac569;
                color: white;
                height: 27px;
            }
            #btnarea{
                width: 100%;
                /* border: 1px solid; */
                text-align: center; 
            }
            #btnarea>button{
                width: 60px;
                height: 30px;
                background-color: white;
                border: 0.5px solid darkgreen;
                text-align: center; 
                border-radius: 5px;
            }
            #btnarea>button:hover{
                cursor: pointer;
                background-color: #3ac569;
                color: white;
            }
            #mtitle{
                border: none;
                width: 100%;
                height: 100%;
            }
            #mcontent{
                resize: none;
                border: none;
                padding: 0;
                margin: 0;
            }
            #mcontent::placeholder{
                font-size: 12px;
                color: #333;
            }


        </style>
    </head>
<body>
    <div class="outer">
        <h3>쪽지보내기</h3>
        <hr>
        <form action ="<%=request.getContextPath() %>/insertMsg.me" method="POST">
        <input type="hidden" name ="mSender" value="<%=nickname%>"> 
        <!-- mSender = loginUser -->
        <input type="hidden" name="mOwner" value="<%= mOwner%>">
        <!-- mOwner = dealWriter -->
            <table>
                <colgroup>
                    <col style="width: 25%">
                    <col style="width: 75%">
                </colgroup>
                <tr>
                    <td id="label">제목</td>
                    <td><input type="text" id="mTitle" name="mTitle"></td>
                </tr>

                <tr>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <td id="label">내용</td>
                    <td><textarea name="mContent" id="mContent" cols="50" rows="10" maxlength="100" placeholder="최대 100자까지 작성할 수 있어요."></textarea></td>
                </tr>
            </table>
            <br>
            <div id="btnarea">
                <button id="sendMsg">보내기</button>
                <button type="reset" onclick="window.close();">취소</button>
            </div>
        </form>
    </div>
    
    <script>
    	$("#sendMsg").click(function(){
<%--     		var mSender = <%=mSender%>;
    		var mOwner = <%= mOwner%>; --%>
    		var mcontent = $("#mcontent").val();
    		if(mcontent.trim() == ""){
				alert("내용을 입력하여 주세요.");
				focus();
				return false;
			} 
    	});
    </script>
</body>
</html>