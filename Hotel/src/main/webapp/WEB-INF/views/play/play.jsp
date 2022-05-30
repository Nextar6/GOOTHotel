<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
section {
	margin-left: 500px;
}

footer {
	
}

ul {
	float: left;
}

a {
	text-decoration: none;
}

p {
	clear: both;
}

li {
	text-align: center;
	list-style: none;
}

body {
	font-family: "Apple SD Gothic Neo", "맑은 고딕", "Malgun Gothic", sans-serif;
}

.btn1-group button {
	background-color: #04AA6D; /* Green background */
	border: 1px solid green; /* Green border */
	color: white; /* White text */
	padding: 10px 24px; /* Some padding */
	cursor: pointer; /* Pointer/hand icon */
	float: left; /* Float the buttons side by side */
}

.btn1-group:after {
	content: "";
	clear: both;
	display: table;
}

.btn1-group

 

button


:not

 

(
:last-child

 

)
{
border-right:
none


; /* Prevent double borders */
}
.btn1-group button:hover {
	background-color: #3e8e41;
}

.badge {
	background-color: red;
	color: white;
	padding: 0.2px 3px;
	text-align: center;
	border-radius: 2px;
}

.sidebar {
	float: left;
	color: #1abc9c;
}
</style>
<meta charset="UTF-8">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<title>play</title>
</head>
<body>
	<%@ include file="header.jspf"%>
	<br>

	<h1 style="float: left; color: white;">즐길거리 (PLAY) 게시판</h1>

	<div
		style="background-color: #1abc9c; padding: 25px; text-align: right">
		<form action="anounce" method="get">
			<input type="date"> <select name="pagingCount">
				<option value="5" selected>5
				<option value="10">10
				<option value="20">20
			</select> <select name="select">
				<option value="titleOrContent">제목+내용
				<option value="writer">작성자
			</select> <input type="text" name="keyword" placeholder="search"> <input
				type="submit" value="검색">
		</form>
	</div>

	<br>


	<hr>
	<div class="sidebar">
		<h1>&nbsp;&nbsp;- 카테고리 -</h1>
		<hr>
		<h1>
			<a href="http://localhost:8080/hotel/play/food"
				style="color: #1abc9c;">&nbsp;&nbsp;맛집&nbsp;&nbsp;</a><span
				class="badge">New</span>
		</h1>
		<hr>
		<h1><a href="http://localhost:8080/hotel/play/play-all"
				style="color: #1abc9c;">
			&nbsp;&nbsp;공연정보&nbsp;&nbsp;</a><span class="badge">New</span>
		</h1>
		<hr>
		<h1>
			<a href="http://localhost:8080/hotel/play/themapark"
				style="color: #1abc9c;"> &nbsp;&nbsp;테마파크&nbsp;&nbsp;</a><span class="badge">New</span>
		</h1>
		<hr>
		<h1>
			&nbsp;&nbsp;레져,투어&nbsp;&nbsp;<span class="badge">New</span>
		</h1>


	</div>

	<div class="btn1-group" style="width: auto; float: right;">
		<button type="button" onclick="location.href='play-orderby-like';">인기순</button>
		<button type="button"
			onclick="location.href='play-orderby-price?keyword=min';">가격
			낮은순</button>
		<button type="button"
			onclick="location.href='play-orderby-price?keyword=max';">높은
			가격순</button>
		<button type="button" onclick="location.href='play-orderby-reply'">댓글
			많은 순</button>
	</div>

	<section>
		<h1 style="background-color: #1abc9c; color: white; width: 20%">
			맛집 리스트</h1>

		<div class="readFood" id="readFood"></div>
		<p></p>
		<div class="btn1-group">
			<button id="btn_food_prev" style="margin-right: 900px;">이전</button>
			<button id="btn_food_next">다음</button>
		</div>

		<hr>
		<h1 style="background-color: #1abc9c; color: white; width: 20%">
			공연 정보</h1>
		<div class="readPlay" id="readPlay"></div>
		<p></p>
		<div class="btn1-group">
			<button id="btn_play_prev" style="margin-right: 900px;">이전</button>
			<button id="btn_play_next">다음</button>
		</div>
		<p></p>
		<hr>
		<h1 style="background-color: #1abc9c; color: white; width: 20%">
			테마 파크</h1>
			<div class="readThemapark" id="readThemapark"></div>
		<p></p>

		<hr>
		<h1 style="background-color: #1abc9c; color: white; width: 20%">
			레져, 투어</h1>

	</section>
	<p></p>
	<br>
	<br>
	<hr>

	<p></p>
	<input type="hidden" id="foodButtonControll" value="${foodButtonControll }">
	<input type="hidden" id="playButtonControll" value="${playButtonControll }">
	<input type="hidden" id="page" value="${page }">
	<input type="hidden" id="deleteAlert" value="${delete_result }">
	<input type="hidden" id="insertAlert" value="${insert_result }">
	<input type="hidden" id="updateAlert" value="${update_result }">

	<script type="text/javascript">
	$(document).ready(function() {
		var page = 1;
		getFoodPage();
		getPlayPage();
		getThemaparkPage();
		
		var foodButtonControll = $('#foodButtonControll').val();
		var playButtonControll = $('#playButtonControll').val();
		// themaparkButton
		console.log('page : '+ page);
		console.log('foodButtonControll : '+ foodButtonControll);
		
		// 버튼 클릭시 다음페이지 보이게
		$('#btn_food_next').click(function() {
			
			if(page < foodButtonControll){
			page++;
			console.log('page : ' + page);
			getFoodPage();
			} else if(page >= foodButtonControll) {	
				page = 1;
				getFoodPage();
			}	// $('#btn_next').hide();
		}); // end btn_play_next click()
		$('#btn_play_next').click(function() {	
			if(page < playButtonControll){
			page++;
			console.log('page : ' + page);
			getPlayPage();
			} else if(page >= playButtonControll) {
				page = 1;
				getPlayPage();	
			}
		}); // end btn_play_next click()
		$('#btn_food_prev').click(function(){
			if(page == 1){
				page = foodButtonControll;
				console.log('page : ' + page);
				getFoodPage();
				
				} else 
					page--;
					getFoodPage();
				
		}); // end btn_prev click()
		$('#btn_play_prev').click(function(){
			if(page == 1){
				page = playButtonControll;
				console.log('page : ' + page);
				getPlayPage();
				
				} else 
					page--;
					getPlayPage();
				
		}); // end play_btn_prev click()
		
		
		function getFoodPage() { // 다음페이지 불러오는 
			var url = 'food/readNext/' + page;
			
			$.getJSON(url, function(jsonData) {
				var list = '';
				$(jsonData).each(function(){
					console.log(this);
					
					list += '<div class="page_item">'
					+ '<pre>'
					+ '<ul>'
					+ '<li><a href="food-detail?foodNo=' + this.foodNo + '"><img src="display?fileName=/' + this.foodPic
					+	'" style="height: 220px; width: 160px;" /></a></li>'
					+ '<li>제목 : ' + this.foodTitle + '</li>'
					+ '<li>가격 : ' + this.foodPrice + '</li>'						
					+ '<li>리뷰 갯수 : <a href="food-detail?foodNo=' + this.foodNo + '">' + this.foodReplyCount + '</a></li>'						
				    + '</ul>'
					+ '</pre>'
					+ '</div>';
					
				}); // end each
				$('#readFood').html(list);
			}); // end getJSON
		} // end getFoodPage()
		
		function getPlayPage() { // 다음페이지 불러오는 
			var url = 'play/readNext/' + page;
			
			$.getJSON(url, function(jsonData) {
				var list = '';
				$(jsonData).each(function(){
					console.log(this);
					
					list += '<div class="page_item">'
					+ '<pre>'
					+ '<ul>'
					+ '<li><a href="play-detail?playNo=' + this.playNo + '"><img src="display?fileName=/' + this.playPic
					+	'" style="height: 220px; width: 160px;" /></a></li>'
					+ '<li>제목 : ' + this.playTitle + '</li>'
					+ '<li>가격 : ' + this.playPrice + '</li>'						
					+ '<li>리뷰 갯수 : <a href="play-detail?playNo=' + this.playNo + '">' + this.playReplyCount + '</a></li>'						
				    + '</ul>'
					+ '</pre>'
					+ '</div>';
					
				}); // end each
				$('#readPlay').html(list);
			}); // end getJSON
		} // end getPlayPage()
		
		function getThemaparkPage() { // 다음페이지 불러오는 
			var url = 'themapark/readNext/' + page;
			
			$.getJSON(url, function(jsonData) {
				var list = '';
				$(jsonData).each(function(){
					console.log(this);
					
					list += '<div class="page_item">'
					+ '<pre>'
					+ '<ul>'
					+ '<li><a href="themapark-detail?themaparkNo=' + this.themaparkNo + '"><img src="display?fileName=/' + this.themaparkPic
					+	'" style="height: 220px; width: 160px;" /></a></li>'
					+ '<li>제목 : ' + this.themaparkTitle + '</li>'
					+ '<li>가격 : ' + this.themaparkPrice + '</li>'						
					+ '<li>리뷰 갯수 : <a href="themapark-detail?themaparkNo=' + this.themaparkNo + '">' + this.themaparkReplyCount + '</a></li>'						
				    + '</ul>'
					+ '</pre>'
					+ '</div>';
					
				}); // end each
				$('#readThemapark').html(list);
			}); // end getJSON
		} // end getThemaparkPage()
			
			
			var deleteResult = $('#deleteAlert').val();
			var insertResult = $('#insertAlert').val();
			var updateResult = $('#updateAlert').val();
			if (deleteResult == 'success') {
				alert('글 삭제 성공!');
			}
			if (insertResult == 'success') {
				alert('글 등록 성공!');
			}
			if (updateResult == 'success') {
				alert('글 수정 성공!')
			}

		});
	</script>
	<footer>
		<%@ include file="footer.jspf"%>
	</footer>

</body>

</html>
