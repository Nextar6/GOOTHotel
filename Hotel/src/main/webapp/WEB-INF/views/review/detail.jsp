<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul, li{
   list-style:none;
   padding-left:0px;
}
a {
	color: #FFFF02;
	font-size: 3em;
}
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Review</title>
</head>
<body>
	<h1>리뷰</h1>
	<button id="btn_review">${vo.memberUserid}님의 리뷰</button>
	<div id="re" style="display: none;">
		<c:forEach var="list" items="${list }">
				<input type="hidden" id="reviewNo" value="${list.reviewNo}">
				<input type="hidden" id="hotelNo" value="${list.hotelNo }">
				<input type="hidden" id="reviewWriter" value="${list.reviewWriter }">
			<ul class="reviewTop" style="height: auto; min-height: 70px; width: 80%; border:2px solid black;">
				<li>호텔 이름 : ${list.hotelTitle}</li>
				<fmt:formatDate value="${list.reviewCdate }" 
						pattern="yyyy-MM-dd HH:mm:ss" var="reviewCdate"/>
				<li>작성일 : ${reviewCdate }</li>
				<li style="float: right;">작성자 : ${list.reviewWriter}</li>
				<c:choose>
					<c:when test="${list.reviewGrade eq '1'}">
						<li>평점 : <a>★</a><a style="color: #F0F0F0;">☆☆☆☆</a></li>
					</c:when>
					<c:when test="${list.reviewGrade eq '2'}">
						<li>평점 : <a>★★</a><a style="color: #F0F0F0;">☆☆☆</a></li>
					</c:when>
					<c:when test="${list.reviewGrade eq '3'}">
						<li>평점 : <a>★★★</a><a style="color: #F0F0F0;">☆☆</a></li>
					</c:when>
					<c:when test="${list.reviewGrade eq '4'}">
						<li>평점 : <a>★★★★</a><a style="color: #F0F0F0;">☆</a></li>
					</c:when>
					<c:when test="${list.reviewGrade eq '5'}">
						<li>평점 : <a>★★★★★</a></li>
					</c:when>
				</c:choose>
				<li style="float: right;">
				<a href="../review/update?reviewNo=${list.reviewNo }"><input type="button" value="수정"></a>
				<a href="../review/delete?reviewNo=${list.reviewNo }&reviewWriter=${list.reviewWriter}"><input type="button" value="삭제"></a>
				</li>
			</ul>
			<ul id="reviewMain" style="height: auto; min-height: 300px; width: 80%; border:2px solid black;">
				<li>
					<c:if test="${not empty list.reviewPic }">
						<c:set var="image" value="${list.reviewPic}"/>
						<c:set var="images" value="${fn:replace(image, '/thumbnail_', '/')}"/>
						<c:set var="a" value="${fn:split(images, ',')}"/>
							<c:if test="${not fn:contains(image, ',')}">
									<img src="displayReview?fileName=${images}">
							</c:if>
							<c:if test="${fn:contains(image, ',')}">
								<c:forEach var="a" items="${a}">
									<img src="displayReview?fileName=${a}">
								</c:forEach>
							</c:if>
					</c:if>
				</li>
				<li>${list.reviewContent }</li>
			</ul>
			<br>
		</c:forEach>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#btn_review').click(function() {
				if($('#re').css('display') == 'none'){
					$('#re').show();
				} else {
					$('#re').hide();
				}
			});
		}); // end document.ready()
	</script>
</body>
</html>