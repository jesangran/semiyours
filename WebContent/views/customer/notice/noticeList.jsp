
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
	<style>
		#outer{
			border:1px solid red;
			width: 1280px;
            height:800px;
		}
		table{
			border:1px solid black;
			text-align: center;
			border-collapse: collapse;
		}
		#tableArea, #detailArea {
			border:1px solid red;
			width:700px;
			height:750px;
			margin-left:auto;
			margin-right:auto;
		}
		th{
			border-bottom:2px solid green;
			height: 30px;
		}
		td{
			border-bottom:2px solid black;
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
	</style>

</head>
<body>
	<div id="outer"><!-- 공지사항이 들어갈 틀 -->
		<br>
		
		<div id="tableArea"><!-- 공지사항 내용이 대한 제목들 -->
			<table align="center" id "listArea"><!-- 공지사항 테이블 -->
				<tr><!-- 테이블 길이 width : 700 -->
					<th width="400px">제목</th>
					<th width="100px">작성자</th>
					<th width="100px">작성일</th>
					<th width="100px">조회수</th>
				</tr>
				<tr>
					<td>한미·한미일 내일 외교장관 회담…美, 한일갈등 중재 주목</td>
					<td>귀뚜라미</td>
					<td>2019.08.01</td>
					<td>2020</td>
				</tr>
				<tr>
					<td>한일갈등 중재 주목 2일 국무회의→4일 고위당정청…日 대응 시나리오</td>
					<td>곰돌이</td>
					<td>2019.07.30</td>
					<td>20</td>
				</tr>
				<tr>
					<td>118일만의 안건처리 국회 본회의…추경 처리 주목</td>
					<td>또끼</td>
					<td>2019.07.29</td>
					<td>24</td>
				</tr>
				<!-- <tr>
					<td colspan="4">공지사항이 없습니다.</td>
				</tr> -->	
			</table>
		</div>
			<br>	<br>
		<!-- 공지사항 상세페이지 -->
		<div id="detailArea" align="center">
			<table align="center" id "InformArea"><!-- 공지사항 테이블 -->
				<tr><!-- 테이블 길이 width : 700 -->
					<th width="500px">제목</th>
					<th width="100px">작성자</th>
					<th width="100px">작성일</th>
				</tr>
				<!-- <tr>
					<td colspan="4">공지사항이 없습니다.</td>
				</tr> -->	
			</table>
			<br>
			<div class="wrap">
		            대한민국은 통일을 지향하며, 자유민주적 기본질서에 입각한 평화적 통일 정책을 수립하고 이를 추진한다. 대법원장은 국회의 동의를 얻어 대통령이 임명한다.
		            나는 헌법을 준수하고 국가를 보위하며 조국의 평화적 통일과 국민의 자유와 복리의 증진 및 민족문화의 창달에 노력하여 대통령으로서의 직책을 성실히 수행할 것을 국민 앞에 엄숙히 선서합니다.
		            대통령은 헌법과 법률이 정하는 바에 의하여 국군을 통수한다. 국회의원과 정부는 법률안을 제출할 수 있다. 헌법에 의하여 체결·공포된 조약과 일반적으로 승인된 국제법규는 국내법과 같은 효력을 가진다.
		            위원은 탄핵 또는 금고 이상의 형의 선고에 의하지 아니하고는 파면되지 아니한다. 국무위원은 국무총리의 제청으로 대통령이 임명한다. 국가는 지역간의 균형있는 발전을 위하여 지역경제를 육성할 의무를 진다.
		            국가는 주택개발정책등을 통하여 모든 국민이 쾌적한 주거생활을 할 수 있도록 노력하여야 한다. 대통령이 궐위된 때 또는 대통령 당선자가 사망하거나 판결 기타의 사유로 그 자격을 상실한 때에는 60일 이내에 후임자를 선거한다.
		            국가는 대외무역을 육성하며, 이를 규제·조정할 수 있다. 제2항과 제3항의 처분에 대하여는 법원에 제소할 수 없다. 교육의 자주성·전문성·정치적 중립성 및 대학의 자율성은 법률이 정하는 바에 의하여 보장된다.
		            공개하지 아니한 회의내용의 공표에 관하여는 법률이 정하는 바에 의한다. 모든 국민은 소급입법에 의하여 참정권의 제한을 받거나 재산권을 박탈당하지 아니한다.
		            국정의 중요한 사항에 관한 대통령의 자문에 응하기 위하여 국가원로로 구성되는 국가원로자문회의를 둘 수 있다. 모든 국민은 양심의 자유를 가진다. 국회는 국가의 예산안을 심의·확정한다.
		            국회의원은 국가이익을 우선하여 양심에 따라 직무를 행한다. 원장은 국회의 동의를 얻어 대통령이 임명하고, 그 임기는 4년으로 하며, 1차에 한하여 중임할 수 있다.
		            모든 국민은 능력에 따라 균등하게 교육을 받을 권리를 가진다. 형사피해자는 법률이 정하는 바에 의하여 당해 사건의 재판절차에서 진술할 수 있다. 국토와 자원은 국가의 보호를 받으며, 국가는 그 균형있는 개발과 이용을 위하여 필요한 계획을 수립한다.
		            모든 국민은 보건에 관하여 국가의 보호를 받는다. 대법원장과 대법관이 아닌 법관은 대법관회의의 동의를 얻어 대법원장이 임명한다. 모든 국민은 사생활의 비밀과 자유를 침해받지 아니한다.
		            저작자·발명가·과학기술자와 예술가의 권리는 법률로써 보호한다. 국회는 헌법 또는 법률에 특별한 규정이 없는 한 재적의원 과반수의 출석과 출석의원 과반수의 찬성으로 의결한다. 가부동수인 때에는 부결된 것으로 본다.
		            각급 선거관리위원회는 선거인명부의 작성등 선거사무와 국민투표사무에 관하여 관계 행정기관에 필요한 지시를 할 수 있다. 지방의회의 조직·권한·의원선거와 지방자치단체의 장의 선임방법 기타 지방자치단체의 조직과 운영에 관한 사항은 법률로 정한다.
		            제1항의 탄핵소추는 국회재적의원 3분의 1 이상의 발의가 있어야 하며, 그 의결은 국회재적의원 과반수의 찬성이 있어야 한다. 다만, 대통령에 대한 탄핵소추는 국회재적의원 과반수의 발의와 국회재적의원 3분의 2 이상의 찬성이 있어야 한다.
		            제3항의 승인을 얻지 못한 때에는 그 처분 또는 명령은 그때부터 효력을 상실한다. 이 경우 그 명령에 의하여 개정 또는 폐지되었던 법률은 그 명령이 승인을 얻지 못한 때부터 당연히 효력을 회복한다.
	    	</div>
	    	<br>
		</div>
	<!------- 페이징 바 ------->
		<!-- 페이징 처리 시작! -->
	<div class="pagingArea" align="center">
		<!-- 맨 처음으로(<<) -->
		<span class="pagingBtn clickBtn" onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=1'">&lt;&lt;</span>
	
		<!-- 이전 페이지로(<) -->
			<span class="pagingBtn">&lt;</span>
			<span class="pagingBtn clickBtn">&lt;</span>
				<span class="pagingBtn selectBtn"></span>
				<span class="pagingBtn clickBtn"></span>

		
		<!-- 다음 페이지로(>) -->
			<span class="pagingBtn"> &gt; </span>

			<span class="pagingBtn clickBtn">&gt;</span>

		
		<!-- 맨 끝으로(>>) -->
		<span class="pagingBtn clickBtn">&gt;&gt;</span>
	</div>
	
	<br><br><br>
	<div class="searchArea" align="center">
		<select id="searchCondition" name="searchCondition">
			<option>-----</option>
			<option value="category">카테고리</option>
			<option value="writer">작성자</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="search">
		<button type="submit">검색하기</button>
		
		<%-- <!-- 로그인한 유저만 글 쓰기 가능 -->
		<% if(loginUser != null){ %>
			<button type="button" onclick="location.href='<%=request.getContextPath()%>/insertForm.bo'">글쓰기</button>
		<% } %> --%>
	</div>
	</div>						
</body>
</html>