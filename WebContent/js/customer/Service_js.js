// FAQ, 공지사항 페이지 화면 출력
$(function() {
	var selected_btn;
	$tab_btn = $(".tab_btn");
	$table_group = $(".table_group");

	var loadPage = function(target, cpage) {
		$(target).html("loading...");		
		$.ajax({// 각각 맞는 호출을 하여 값을 반환받아오는 코드
			url : tab_urls[target],
			type : "post",
			data : {
				curpage : cpage
			},
			success : function(result) {
				// 받아온 데이터를 화면에 출력
				$(target).html(result);
				console.log("success");
			},
			error : function(err) {
				console.log("error: " + err);
			},
			complete : function() {
				console.log("complete!");
			}
		});
	};
	// 클릭한 목록에 따른 화면 출력
	$tab_btn.find("button").click(function() {
		var obj = $(this);
		var target = $(this).attr("target");

		$tab_btn.find("button").removeClass("on");
		obj.addClass("on");

		$table_group.find(".imsi_outer").hide();
		if (tab_urls[target] != null) {
			loadPage(target, 1);
		}
		$table_group.find(target).show();
	});
	/*
	 * FAQ, 공지사항 페이지에 따른 화면 출력
	 * $(숫자버튼).click(function () { loadPage(현재 탭, 불러올 페이지 번호); }
	 */
	$(".table_group").on("click", ".pagingBtn", function() {
		var text = $(this).text();
		if (jQuery.isNumeric(text)) {
			var target = $tab_btn.find("button.on").attr("target");
			var num = parseInt(text);
			alert(num); 
			alert(target);
			
			/*var loadPage = function(target, num) {
				alert(target);
				alert(num);
				$.ajax({// 각각 맞는 호출을 하여 값을 반환받아오는 코드
					url : "/noticeList.no?currentPage=" + num,
					type : "post",
					success : function(result) {
						// 받아온 데이터를 화면에 출력
						$(target).html(result);
						console.log("success");
					},
					error : function(err) {
						console.log("error: " + err);
					},
					complete : function() {
						console.log("complete!");
					}
				});

			};*/
		}
	});
	// 고객센터 첫페이지를 0번째 버튼인 FAQ로 화면 출력
	$tab_btn.find("button")[0].click();
});
// 상세페이지로 넘어갈 시 이전 페이지인 화면으로 이동
$(function() {
	$("#Ajax_outer #back").on("click", function() {
		$(".switching_btn .on").click();
	});
});
// FAQ 상세페이지 이동
$(function() {
	// 게시판 상세보기#cff09e
	$("#FAQ_List_outer").on("mouseenter", "#FAQ_listArea td", function() {
		$(this).parent().css({
			"background" : "#cff09e",
			"cursor" : "pointer"
		});
	}).on("mouseleave", "#FAQ_listArea td", function() {
		$(this).parent().css({
			"background" : "white"
		});
	}).on("click", "#FAQ_listArea td", function() {
		var num = $(this).parent().children().eq(0).text();
		// GET방식의 쿼리스트링을 이용하여 글 번호 전달

		/*
		 * var url = document.URL.substr(0, document.URL.indexOf("/",
		 * document.URL.indexOf("/", document.URL.indexOf("//") + 2) + 1));
		 * 
		 * location.href = url + "/faqDetail.no?fno="+num;
		 */
		$.ajax({
			url : "faqDetail.no?fno=" + num,

			// data : 요청 시 전달할 파라미터 설정
			// data : {input : input},
			// key value
			// var input

			// type : get / post 전송 방식
			type : "get",

			// success : Ajax 통신 성공시 처리 할 함수 지정
			success : function(result) {
				// 함수 매개변수에 응답 데이터가 전달됨.
				// 매개변수명은 임의 지정 가능

				console.log("ajax 통신 성공");
				$table_group.find(".imsi_outer").hide();
				$("#Ajax_outer #content").html(result);
				$("#Ajax_outer").show();
			},

			// error : Ajax 통신 실패 시 처리 할 함수 지정
			error : function(err) {
				console.log(err);
				console.log("Ajax 통신 실패");
				$table_group.val("에러발생");
			},
			// comlete : 무조건 실행 / Ajax 통신 완료 시 처리할 함수 지정
			// Ajax통신 성공여부와 관계없이 통신 완료 후 실행되는 함수 지정
			complete : function() {
				console.log("Ajax 통신 완료");
			}
		});
	});
});

// 공지사항 상세페이지 이동
$(function() {
	// 게시판 상세보기 / #cff09e
	$("#noticeList_outer").on("mouseenter", "#noticeList_listArea td",
			function() {
				$(this).parent().css({
					"background" : "#cff09e",
					"cursor" : "pointer"
				});
			}).on("mouseleave", "#noticeList_listArea td", function() {
		$(this).parent().css({
			"background" : "white"
		});
	}).on("click", "#noticeList_listArea td", function() {
		var num = $(this).parent().children().eq(0).text();
		// GET방식의 쿼리스트링을 이용하여 글 번호 전달

		/*
		 * var url = document.URL.substr(0, document.URL.indexOf("/",
		 * document.URL.indexOf("/", document.URL.indexOf("//") + 2) + 1));
		 * 
		 * location.href = url + "/faqDetail.no?fno="+num;
		 */
		$.ajax({
			url : "noticeDetail.no?nNo=" + num,
			type : "get",
			success : function(result) {
				console.log("ajax 통신 성공");
				$table_group.find(".imsi_outer").hide();
				$("#Ajax_outer #content").html(result);
				$("#Ajax_outer").show();
			},
			// error : Ajax 통신 실패 시 처리 할 함수 지정
			error : function(err) {
				console.log(err);
				console.log("Ajax 통신 실패");
				$table_group.val("에러발생");
			},
			complete : function() {
				console.log("Ajax 통신 완료");
			}
		});
	});
});
