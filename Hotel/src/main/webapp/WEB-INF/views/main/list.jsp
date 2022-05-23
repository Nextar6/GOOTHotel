<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty userid }">
		<button id="btn_login">로그인</button>
	</c:if>
	<c:if test="${not empty userid }">
		<button id="btn_logout">로그아웃</button>
		<button id="btn_profile">회원정보</button>
	</c:if>
	
	<input type="hidden" id="deleteAlert" value="${delete_result }">
	
	<script type="text/javascript">
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
		});
		
		$(document).ready(function() {
			var result = $('#deleteAlert').val();
			if(result == "success"){
				alert('회원 탈퇴 성공 !');
			}
		});
		
	</script>
</body>
</html>