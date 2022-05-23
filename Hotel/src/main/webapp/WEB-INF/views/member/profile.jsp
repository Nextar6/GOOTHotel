<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>profile</title>
</head>
<body>
	<h1>${vo.memberUserid }님 프로필</h1>
	<div>
		<p>회원 번호 : ${vo.memberNo }</p>
	</div>
	<div>
		<p>아이디 : ${vo.memberUserid }</p>
	</div>
	<div>
		<p>비밀번호 : ${vo.memberPassword }</p>
	</div>
	<div>
		<p>이메일 : ${vo.memberEmail }</p>
	</div>
	<div>
		<p>주민번호 : ${vo.memberSSN }</p>
	</div>
	<div>
		<p>핸드폰 : ${vo.memberPhone }</p>
	</div>
	<div>
		<p>이름 : ${vo.memberName }</p>
	</div>
	<div>
		<p>주소 : ${vo.memberAddress }</p>
	</div>
	<button id="btn_review">내가 작성한 리뷰</button>
	<button id="btn_reservat">내 예약 보기</button>
	<hr>
	<button id="btn_update">회원 정보 수정</button>
	<button id="btn_delete">회원 탈퇴</button>
	
	
	<input type="hidden" id="userid" value="${vo.memberUserid }">
	<input type="hidden" id="updateAlert" value="${update_result }">
	<input type="hidden" id="deleteAlert" value="${delete_result }">
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#btn_update').click(function() {
				location = '../member/update?memberUserid=${vo.memberUserid}';
			}); // end btn_update.click()
			$('#btn_delete').click(function() {
				location = '../member/delete?memberUserid=${vo.memberUserid}';
			}); // end btn_delete.click()
			$('#btn_review').click(function() {
				location = '../review/detail?reviewWriter=${vo.memberUserid}';
			}); // end btn_review.click()
			$('#btn_reservat').click(function() {
				location = '../reservat/detail?reservatUserid=${vo.memberUserid}';
			}); // end btn_reservat.click()
		}); // end document.ready()
		
		$(document).ready(function() {
			var result = $('#updateAlert').val();
			if(result == "success"){
				alert('회원 정보 수정 성공 !');
			}
		});
		$(document).ready(function() {
			var result = $('#deleteAlert').val();
			if(result == "fail"){
				alert('회원 탈퇴 실패 !');
			}
		});
		
	</script>
</body>
</html>