<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>login</title>
</head>
<body>
	<div class="container">
		<h1 style="text-align: center;">로그인</h1>
		<br>
		<%
			if (session.getAttribute("userid") != null) {
				response.sendRedirect("/hotel/main/main");
			}
		%>
		<hr>
		<form class="form-horizontal" action="login" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="memberUserid">아이디
					: </label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="memberUserid"
						name="memberUserid" required placeholder="ID" autofocus>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">비밀번호 :
				</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password"
						name="memberPassword" required placeholder="PASSWORD">
				</div>
			</div>
			<br> 
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-default" style="float: right;"
						value="로그인">
				</div><br><br>
				<div class="col-sm-offset-2 col-sm-10">
					<button id="btn_register" class="btn btn-default" style="float: right; ">회원가입</button>
					<button id="btn_find" class="btn btn-default" style="float: right; margin-right: 10px">아이디, 비밀번호 찾기</button>
				</div>
			</div>
		</form>
	</div>

	<input type="hidden" id="findUseridAlert"
		value="${find_userid_result }">
	<input type="hidden" id="findPasswordAlert"
		value="${find_password_result }">
	<input type="hidden" id="insertMemberAlert" value="${insert_result }">
	<input type="hidden" id="loginMemberAlert" value="${login_result }">

	<script type="text/javascript">
		$(document).ready(function() {
			var result = $('#findUseridAlert').val();
			if (result != '') {
				if (result != null) {
					alert('아이디 찾기 성공 ! \n 아이디 : ' + result);
				}
			}
		});

		$(document).ready(function() {
			var result = $('#findPasswordAlert').val();
			if (result != '') {
				if (result != null) {
					alert('비밀번호 찾기 성공 ! \n 비밀번호 : ' + result);
				}
			}
		});

		$(document).ready(function() {
			var result = $('#insertMemberAlert').val();
			if (result == 'success') {
				alert('회원가입 성공 !');
			}
		});

		$(document).ready(function() {
			var result = $('#loginMemberAlert').val();
			if (result == 'fail') {
				alert('로그인 실패 ! \n아이디와 비밀번호를 확인해주세요.');
			}
		})

		$(document).ready(function() {
			$('#btn_register').click(function() {
				location = '/hotel/member/register';
			});
			$('#btn_find').click(function() {
				location = '../member/find';
			});
		});
	</script>
</body>
</html>