
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A 게시판</title>
	<style>
		#outer{/* 문의하기 틀 스타일*/
			/* border:1px solid red; */
			background-color:blanchedalmond;
			width: 1280px;
            height:800px;
		}
		table{/* 문의하시 테이블 스타일 */
			/* border:1px solid black; */
			text-align: center;
			border-collapse: collapse;
		}
		#tableArea, #detailArea {
			/* border:1px solid red; */
			width:700px;
			height:750px;
			margin-left:auto;
			margin-right:auto;
		}
		/* .searchArea {
			width:650px;
			margin-left:auto;
			margin-right:auto;
		} */
		th{
			/* border-bottom:2px solid green; */
			height: 30px;
		}
		td{
			/* border: 1px solid red; */
			/* border-bottom:2px solid black; */
			height: 30px;
		}
		.wrap{
            /* border:1px solid black; */
            width: 680px;
            height:400px;
            overflow:auto;
        }
        .comment_btn{
        	width: 100px;
        	height: 40px;
        }
        .input_width{
        	width: 600px;
        	border-left: none;
        }
         #text_id{
        	width: 700px;
        	height: 400px;
        }
	</style>

</head>
<body>
	<div id="outer"><!-- 문의하기이 들어갈 틀 -->
		<br>
		
		<div id="tableArea"><!-- 문의하기 내용이 대한 제목들 -->
			<table align="center" id "listArea"><!-- 문의하기 테이블 -->
				<tr><!-- 테이블 길이 width : 700 -->
					<th width="100px" ><h3>문의하기 |</h3></th>
					<th width="600px"><h3>문의하실 내용을 보내 주시면 최선을 다해 도움 드리겠습니다.
					</h3></th>
				</tr>
				<tr>
					<td width="100px">메일주소</td>
					<td width="600px"><input type="text" class="input_width"></td>
				</tr>
				<tr>
					<td width="100px">제  목</td>
					<td width="600px"><input type="text" class="input_width"></td>
				</tr>
				<tr>
					<td colspan="2">
					<textarea id="text_id" cols="90" rows="20" style="resize:none"></textarea>
					</td>
				</tr>
				<tr>
					<td class="asd">첨부파일 |</td>
					<td><input type="file" name="File" class="input_width"></td>
				</tr>
				<tr>
					<td colspan="2"><button>확인</button><span>     </span><button>취소</button></td>
				</tr>
				
			</table>
		</div>
		<br>
	</div>						
</body>
</html>