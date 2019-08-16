<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#reportArea {
	width: 400px;
	height: 300px;
	border: 1px solid black;
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
		<form action="<%= request.getContextPath()%>/reportInsert.bo" method="post">
			<table id ="insertFrm">
				<tr>
					<td>신고물유형</td>
					<td>
						<select name= "reportType">
							<option value="1">거래게시판</option>
							<option value="2">거래게시판댓글</option>
							<option value="3">자유게시판</option>
							<option value="4">자유게시판댓글</option>
							<option value="5">팁게시판</option>
							<option value="6">팁게시판댓글</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>글번호</td>
					<td><input type="text" name="no"></td>
				</tr>
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