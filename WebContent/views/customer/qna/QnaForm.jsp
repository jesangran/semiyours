
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 문의하기이 들어갈 틀 -->
<div id="QNA_tableArea">
	<!-- 문의하기 내용이 대한 제목들 -->
	<form onsubmit="validate();" method="post" action="<%=request.getContextPath()%>/insert.qna"
		enctype="multipart/form-data">

		<table id="QNA_listArea">
			<!-- 문의하기 테이블 -->
			<tr id="QNA_title" align="left">
				<th colspan="2">문의하기 | 문의하실 내용을 보내 주시면 최선을 다해 도움 드리겠습니다.</th>
			</tr>
			<tr>
				<td class="QNA_align">문의유형</td>
				<td id="QnaType">
					<select style="height: 25px;" id="category" name="category">
							<option value="유형선택">유형선택</option>
							<option value="회원관련">회원관련</option>
							<option value="게시물관련">게시물관련</option>
							<option value="이용관련">이용관련</option>
							<option value="기타">기 타</option>
					</select>
				</td>
			</tr>
			<tr>
				<td width="100px" class="QNA_align">제 목</td>
				<td width="600px" class="QNA_align">
					<input type="text"
						id="Qnatitle" name="title" class="input_width"
						placeholder="문의 제목을 적어주세요.">
				</td>
			</tr>
			<tr>
				<!-- 내용 -->
				<td colspan="2"><textarea id="content" name="content" cols="90"
						rows="20" style="resize: none"></textarea></td>
			</tr>
			<tr>
				<td class="QNA_align">첨부파일</td>
				<td><input type="file" name="File" class="input_width"></td>
			</tr>
			<tr>
				<td colspan="2" class="QNA_align"><button type="submit">확인</button>
					<span> </span> | <span> </span>
					<button type="reset">취소</button></td>
			</tr>
			<tr>
				<td><input style="border: 0;"></td>
			</tr>
		</table>
	</form>
	<!-- 문의 유효성 검사 -->
	<script>
	/* option:selected").trim() */
		function validate(){
			if( $("#category").val() == "유형선택"){
				alert("유형을 선택해주세요");
				$("#QnaType").focus();
				
				return false;
			}
			/* option:selected" */
			if( $("#Qnatitle").val() == "" ){
				alert("제목을 입력해 주세요!");
				$("#Qnatitle").focus();
				
				return false;
			}
			if( $("#content").val() == "" ){
				alert("내용을 입력해 주세요!");
				$("#content").focus();
				
				return false;
			} 
			 alert("문의사항 등록이 완료되었습니다.");
			if( $("#category option:selected").val != null && $("#Qnatitle").val() != null && $("#text_id").val() != null){
				action="<%=request.getContextPath()%>/insert.qna"
			}
			return true;

		}
	</script>
</div>