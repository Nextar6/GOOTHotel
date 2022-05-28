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
border-right
:
 
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

.input-txt {
	font-size: 32px;
	line-height: 38px;
	height: 38px;
	margin-right: 20px;
	color: #222;
	border: 1px solid #dddbda;
	background: #fff;
}
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<title>food</title>
</head>
<body>
	<%@ include file="header.jspf"%>
	<br>



	<h1 style="float: left; color: white;">맛집 게시판</h1>

	<div
		style="background-color: #1abc9c; padding: 25px; text-align: right">
		<form action="food-search" method="get">


			<input class="input-txt" list="recommend-list" id="input-txt"
				name="keyword" placeholder="맛집검색">
			<datalist id="recommend-list">
				<option class="recommend" id="recommend">
			</datalist><button type="submit" class="search_button" style="background:#1abc9c;" >
				<img style="height:35px;"
					src="display?fileName=/sp_gnb_2x_202234_133301 (2).png" />
			</button>
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
		<h1>
			<a href="http://localhost:8080/hotel/play/play-all"
				style="color: #1abc9c;"> &nbsp;&nbsp;공연정보&nbsp;&nbsp;</a><span
				class="badge">New</span>
		</h1>
		<hr>
		<h1>
			&nbsp;&nbsp;테마파크&nbsp;&nbsp;<span class="badge">New</span>
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
		<br> <a href="food-insert"><input type="hidden" value="글작성"
			style="width: auto; float: right;"></a>
		<div class="infinite">
			<c:forEach var="vo" items="${foodList }">
				<ul>

					<!-- indexO로 ,위치찾고 subString으로 자름-->
					<c:set var="searchIndex" value="${fn:indexOf(vo.foodPic, ',') }" />
					<c:set var="thumbnail"
						value="${fn:substring(vo.foodPic, 0 , searchIndex)}" />
					<c:set var="cutThumbnail"
						value="${fn:replace(thumbnail, 's_', '') }" />
					<li><a href="food-detail?foodNo=${vo.foodNo }"><img
							src="display?fileName=/${cutThumbnail}"
							style="height: 220px; width: 160px;" /></a></li>
					<li>제목 : <a href="food-detail?playNo=${vo.foodNo }">${vo.foodTitle }</a></li>
					<li>가격 : ${vo.foodPrice }</li>
					<!-- 리뷰 갯수 -->
					<li>리뷰 갯수 : <a href="play-detail?foodNo=${vo.foodNo }">[${vo.foodReplyCount }]</a></li>
				</ul>
			</c:forEach>
		</div>
		<p></p>


	</section>
	<p></p>
	<br>
	<br>
	<hr>



	<input type="hidden" id="deleteAlert" value="${delete_result }">
	<input type="hidden" id="insertAlert" value="${insert_result }">
	<input type="hidden" id="updateAlert" value="${update_result }">

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#input-txt')
									.keyup(
											function() {
												var keyword = $('#input-txt')
														.val();
												console.log(keyword);
												var url = 'recommend-search/'
														+ keyword;
												$
														.getJSON(
																url,
																function(
																		jsonData) {
																	console
																			.log(jsonData);
																	var list = '';
																	$(jsonData)
																			.each(
																					function() {
																						console
																								.log(this);
																						list += '<div class="resultList">'
																								+ '<pre>'
																								+ '<option value="' + this.foodTitle + '">'
																								+ '</pre>'
																								+ '</div>';
																					}); // end each()
																	$(
																			'#recommend')
																			.html(
																					list);

																}); // end getJSON

											}); // end keyup

						}); // end document

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
			alert('글 수정 성공!');
		}
	</script>
	<footer>
		<%@ include file="footer.jspf"%>
	</footer>

</body>

</html>
