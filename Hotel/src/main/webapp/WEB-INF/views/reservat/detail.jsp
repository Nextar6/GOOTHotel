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
 list-style: none;
 padding-left: 0px;
}
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>reservat</title>
</head>
<body>
	<h1>예약</h1>
	<c:forEach var="list" items="${list }">
		<input type="hidden" id="reservatNo" value="${list.reservatNo }">
		<input type="hidden" id="hotelNo" value="${list.hotelNo }">
		<input type="hidden" id="reservatUserid" value="${list.reservatUserid }">
		<div class="reservat" style="border: 2px solid black;">
			<ul class="reservatTop" style="border-bottom: 2px solid black; line-height: 30px;">
				<li>호텔 이름 : ${list.hotelTitle}</li>
				<li>예약자 : ${list.reservatUserid}</li>
				<li style="float: right;">
				<a href="../reservat/update?reservatNo=${list.reservatNo}"><input type="button" value="수정"></a>
				<a href="../reservat/delete?reservatNo=${list.reservatNo}"><input type="button" value="삭제"></a>
				</li>
				<fmt:formatDate value="${list.reservatCdate }"
	                 	pattern="yyyy-MM-dd HH:mm:ss" var="reservatCdate"/>
				<li>예약한 시간 : ${reservatCdate }</li>
			</ul>
			<ul class="reservatBottom">
				<li>체크인 날짜 : ${list.checkIn }</li>
				<li>체크아웃 날짜 : ${list.checkOut }</li>
				<li>총 일수 : ${list.reservatNight }</li>
				<li>인원 수 : ${list.reservatPeople }</li>
				<li>총 결제 금액 : ${list.reservatPrice}</li>
			</ul>
		</div>
		<br>
	</c:forEach>
</body>
</html>