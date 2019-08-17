<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int no = (Integer)request.getAttribute("no");
int rType = (Integer)request.getAttribute("rType");
int reporter = (Integer)request.getAttribute("reporter");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#reportArea {
	width: 100%;
	height: 100%;
	
	font-size: 12px;
}

#reportArea>form {
	width: 100%;
	height: 100%;
}

#insertFrm {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
}
</style>
<body>
    <div id="reportArea">
		<form action="<%= request.getContextPath()%>/insert.re" method="post">
			<input type="hidden" name="no" value="<%=no%>">
			<input type="hidden" name="rType" value="<%=rType%>">
			<input type="hidden" name="reporter" value="<%=reporter%>">
			<table id ="insertFrm">
				<tr>
					<td>신고사유</td>
					<td colspan="3">
						<select name="reportReason">
							<option value="1">욕설</option>
							<option value="2">선정</option>
							<option value="3">광고</option>
							<option value="4">도박</option>
							<option value="5">기타</option>
						</select>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>신고내용</td>
					<td colspan="3"><textarea rows="5" cols="40" name="reportCon" style="resize: none"></textarea></td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button type="submit">신고하기</button>
				<button type="reset" onclick= "window.close();">취소</button>
			</div>
		</form>
    </div>
    
</body>
</html>