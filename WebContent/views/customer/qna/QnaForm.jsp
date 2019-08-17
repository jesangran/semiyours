
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 문의하기이 들어갈 틀 -->
<div id="QNA_tableArea">
	<!-- 문의하기 내용이 대한 제목들 -->
	<form action="<%= request.getContextPath() %>/insert.qna" method="post" enctype="multipart/form-data">
	<table id="QNA_listArea">
		<!-- 문의하기 테이블 -->
		<tr id="QNA_title" align="left">
			<th colspan="2">문의하기 | 문의하실 내용을 보내 주시면 최선을 다해 도움 드리겠습니다.</th>
		</tr>
		<tr>
			<td class="QNA_align">문의유형</td>
			<td id="QnaType">
				<select style="height: 25px;">
					<option>유형선택</option>
					<option value="회원관련">회원관련</option>
					<option value="게시물관련">게시물관련</option>
					<option value="이용관련">이용관련</option>
					<option value="기타">기      타</option>
				</select>
			</td>
		</tr>
		<tr>
			<td width="100px" class="QNA_align">제 목</td>
			<td width="600px" class="QNA_align"><input type="text" id="Qnatitle" class="input_width" placeholder="문의 제목을 적어주세요."></td>
		</tr>
		<tr>
			<td colspan="2"><textarea id="text_id" cols="90" rows="20"
					style="resize: none"></textarea></td>
		</tr>
		<tr>
			<td class="QNA_align">첨부파일</td>
			<td><input type="file" name="File" class="input_width"></td>
		</tr>
		<tr>
			<td colspan="2" class="QNA_align"><button>확인</button><span> </span> | <span> </span>
			<button type="reset">취소</button></td>
		</tr>

	</table>
	</form>
	<!-- 문의 유효성 검사 -->
	<script>
		/* function validate(){
			if( $("#QnaType").val().trim().length == 0 ){
				alert("문의유형을 선택해 주세요");
				$("#QnaType").focus();
				
				return false;
			}
			if( $("#Qnatitle").val().trim().length == 0 ){
				alert("제목을 입력해 주세요!");
				$("#Qnatitle").focus();
				
				return false;
			}
			 if( $("#text_id").val().trim().length == 0 ){
				alert("내용을 입력해 주세요!");
				$("#text_id").focus();
				
				return false;
			} 
			return true;
		} */
	</script>
</div>