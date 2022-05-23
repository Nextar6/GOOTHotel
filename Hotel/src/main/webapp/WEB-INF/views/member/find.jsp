<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>아이디, 비밀번호 찾기</title>
</head>
<body>
	<h1>아이디 찾기</h1>
	<form action="findUserid" method="post">
		<label for="template-contactform-name">E-mail</label>
        <br>
		<input type="text" name="memberEmail" id="memberEmail" size="15" required>
         <label> @ </label>
         <input type="text" name="memberEmail" id="select_mEmail" size="15" required>
		<select name="change_email" onchange="select_email(this.value)">
			<option value="" selected>직접 입력</option>
			<option value="naver.com">naver.com</option>
			<option value="daum.net">daum.net</option>
			<option value="google.com">google.com</option>
			<option value="hanmail.net">hanmail.net</option>
			<option value="korea.com">korea.com</option> 
			<option value="gmail.com">gmail.com</option> 
			<option value="hanmir.com">hanmir.com</option> 
			<option value="paran.com">paran.com</option>
			<option value="nate.com">nate.com</option>
		</select>
		<br>
		<label for="template-contactform-name">전화번호</label>
        <br> 
		<select name="change_first_phone_num" onchange="select_first_phone_num(this.value);">
			<option value="">선택</option>
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="019">019</option>
	    </select>
     	    <input type="text" name="memberPhone" id="first_phone_num" size="6" required value="">
            <label> - </label>
            <input type="text" name="memberPhone" id="memberPhone" maxlength="4" size="6" required>
            <label> - </label>
            <input type="text" name="memberPhone" id="memberPhone" maxlength="4" size="6" required>	
        <br>
        <input type="submit" value="아이디 찾기">
	</form>
	<br>
	<hr>
	<h1>비밀번호 찾기</h1>
	<form action="findPassword" method="post">
		<label for="template-contactform-name">아이디</label> 
        <br>
        <input type="text" name="memberUserid" id="memberUserid" 
            size="35" required="required" maxlength="20">
	 	<br>
	 	<label for="template-contactform-name">전화번호</label>
        <br> 
		<select name="change_first_phone_num" onchange="select_phone_num(this.value);">
			<option value="">선택</option>
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="019">019</option>
	    </select>
     	    <input type="text" name="memberPhone" id="phone_num" size="6" required value="">
            <label> - </label>
            <input type="text" name="memberPhone" id="memberPhone" maxlength="4" size="6" required>
            <label> - </label>
            <input type="text" name="memberPhone" id="memberPhone" maxlength="4" size="6" required>	
        <br>
        <input type="submit" value="비밀번호 찾기">	
	</form>

	<input type="hidden" id="findUseridAlert" value="${find_userid_result }">
	<input type="hidden" id="findPasswordAlert" value="${find_password_result }">	

<script type="text/javascript">
	$(document).ready(function() {
		var result = $('#findUseridAlert').val();
		if(result == 1){
			alert('아이디 찾기 실패 !');
		}
	});
	
	$(document).ready(function() {
		var result = $('#findPasswordAlert').val();
		if(result == 1){
			alert('비밀번호 찾기 실패 !');
		}
	});

	function select_phone_num(value){
		console.log(value);
		if(value == ""){
			$('#phone_num').val(value);
			$('#phone_num').removeAttr('readonly');
		} else {
			$('#phone_num').val(value);
			$('#phone_num').attr('readonly', 'readonly');				
		}		
	}
	
	function select_first_phone_num(value){
		console.log(value);
		if(value == ""){
			$('#first_phone_num').val(value);
			$('#first_phone_num').removeAttr('readonly');
		} else {
			$('#first_phone_num').val(value);
			$('#first_phone_num').attr('readonly', 'readonly');				
		}		
	}
	
	// 이메일 선택
	function select_email(value) {
		console.log(value)
		if(value == ""){
			$('#select_mEmail').val(value);
			$('#select_mEmail').removeAttr('readonly');
		} else {
			$('#select_mEmail').val(value);
			$('#select_mEmail').attr('readonly', 'readonly');
		}
	}	
	</script>
</body>
</html>