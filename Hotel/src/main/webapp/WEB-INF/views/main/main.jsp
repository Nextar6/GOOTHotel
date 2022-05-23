<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
	border-style: solid;
	border-width: 1px;
	text-align: center;
}

ul {
	list-style-type: none;
}

li {
	display: inline-block;
}
</style>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>메인 페이지</title>
</head>

<body>
	<a href="main">HOTEL</a>
	<br>
	<a href="http://localhost:8080/hotel/play/play"><input type="button" value="즐길거리"></a>
	<a href="http://localhost:8080/hotel/board/anounce"><input type="button" value="더보기"></a>
	<c:if test="${empty userid and empty admin}">
		<button id="btn_login">로그인</button>
	</c:if>
	<c:if test="${not empty userid}">
		<button id="btn_logout">로그아웃</button>
		<button id="btn_profile">회원정보</button>
	</c:if>
		<c:if test="${not empty admin}">
		<button id="btn_logout">로그아웃</button>
	</c:if>
	<br>
	<hr>
	<c:if test="${not empty admin }">
		<button id="btn_register">글 작성</button>
	</c:if>
<hr>
	<table>
		<thead>
			<tr>
				<th style="width: 100px">호텔이미지</th>
				<th style="width: 100px">등급</th>
				<th style="width: 400px">호텔이름</th>
				<th style="width: 300px">패키지</th>
				<th style="width: 100px">가격(1일)</th>
				<th style="width: 100px">가격(1인)</th>
				<th style="width: 200px">주소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${main }">
				<tr>
					<td>
					<c:set var="image" value="${vo.hotelPic}"/>
					<c:if test="${not fn:contains(image, ',')}">
						<img src="displayimages?fileName=${image}">
					</c:if>
					<c:if test="${fn:contains(image, ',')}">
						<img src="displayimages?fileName=${fn:split(image, ',')[0]}">
					</c:if>
					</td>
					<td>${vo.hotelGrade}☆</td>
					<td><a href="../hotel/detail?hotelNo=${vo.hotelNo }&page=${pageMaker.criteria.page}">${vo.hotelTitle }</a></td>
					<td>${vo.hotelPackage}</td>
					<td>${vo.hotelPriceNight}</td>
					<td>${vo.hotelPricePeople }</td>
					<td>${vo.hotelAddress}</td>
				</tr>
					</c:forEach>
		</tbody>
	</table>

	<hr>
	<ul>
		<c:if test="${pageMaker.hasPrev }">
			<li><a href="main?page=${pageMaker.startPageNo - 1 }">이전</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPageNo }"
			end="${pageMaker.endPageNo }" var="num">
			<li><a href="main?page=${num }">${num }</a></li>
		</c:forEach>
		<c:if test="${pageMaker.hasNext }">
			<li><a href="main?page=${pageMaker.endPageNo + 1 }">다음</a></li>
		</c:if>
	</ul>
	
	<input type="hidden" id="deleteAlert" value="${delete_result }">
	<input type="hidden" id="deleteHotelAlert" value="${delete_hotel }">
	<input type="hidden" id="loginMemberAlert" value="${login_result }">
	<input type="hidden" id="logoutMemberAlert" value="${logout_result }">
	<input type="hidden" id="loginAdminAlert" value="${admin_login_result }">
	
	<script type="text/javascript">
		$(document).ready(function() {
			$(document).ready(function() {
			$('#btn_login').click(function() {
				var target = encodeURI('/hotel/member/login');
				location = target;
			}); // end btn_login.click()
			$('#btn_logout').click(function() {
				location = '../member/logout';
			}); // end btn_logout.click()
			$('#btn_profile').click(function() {
				location = '../member/profile?memberUserid=${userid}';
			}); // end btn_profile.click()
			$('#btn_register').click(function() {
				location = '../hotel/register';
			}); // end btn_register.click()
		});
		
		$(document).ready(function() {
			var result = $('#deleteAlert').val();
			if(result == "success"){
				alert('회원 탈퇴 성공 !');
			}
		});
		$(document).ready(function() {
			var result = $('#deleteHotelAlert').val();
			if(result == "success"){
				alert('호텔 삭제 성공 !');
			}
		});
		$(document).ready(function() {
			var result = $('#loginMemberAlert').val();
			if(result == "success"){
				alert('로그인 성공 !');
			}
		})
		$(document).ready(function() {
			var result = $('#logoutMemberAlert').val();
			if(result == "success"){
				alert('로그아웃 성공 !');
			}
		})
		$(document).ready(function() {
			var result = $('#loginAdminAlert').val();
			if(result == "success"){
				alert('관리자 로그인 성공 !');
			}
		})
	});
	</script>

</body>
</html>