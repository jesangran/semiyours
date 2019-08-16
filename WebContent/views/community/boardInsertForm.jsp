<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../style/community/boardWriteForm.css">
<script src="../../js/community/js/boardWriteForm.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp" %>

	  <div class="form_outer">
            <div id="board_form_subject">
                <span>                
                    게시판 글쓰기 
                </span>
            </div>
            <div id="board_form_outer">
                <table>
                <colgroup>
                <col style="width:10%">
                <col style="width:90%">
                </colgroup>
                    <thead id="table_head_wrapper">
                        <tr id="border_top">
                            <th class="board_form_title">제목</th>
                            <td colspan="2">
                                <div class="board_form_category">
                                    <select id="select_category" name="selectCategory">
                                        <option value="" selected="selected">카테고리</option>
                                        <option value="freeBoard">자유게시판</option>
                                        <option value="tipBoard">팁게시판</option>
                                    </select>     
                                    <input id="board_form_title" type="text" name="formTitle" >
                                </div>             
                            </td>
                        </tr>
                        <tr>
                            <th class="input_table_title">첨부파일</th>
                            <td>
                                <div class="input-file">
                                    <input type="text" readonly="readonly" class="file-name" />
                                    <label for="upload01" class="file-label">파일 업로드</label>
                                    <input type="file" name="" id="upload01" class="file-upload" />
                                </div>
                            </td>
                        </tr>
                    </thead>
                    <tbody class="input_table_body">
                        <tr>
                            <td colspan="2">
                                <div class="board_content_outer">
                                    <textarea name="" id="board_contentarea"></textarea>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                    <tfoot class="board_table_footer">
                        <tr>
                            <td colspan="2">
                                <div class="board_form_btn">
                                    <button type="submit">등록 </button>
                                    <button type="reset">취소</button>
                                </div>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>
       <%@ include file="../common/footer.jsp"%> 
</body>
</html>