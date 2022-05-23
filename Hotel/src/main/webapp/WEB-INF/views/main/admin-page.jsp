<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="row">
	<input type="button" class="btn btn_1 col-sm-5 mx-4"
	id="btn_1" value="회원 1:1문의 내역 확인"/>
	<input type="button" class="btn btn_2 col-sm-5 mx-4"
	id="btn_2" value="더보기 게시판 글 관리"/>
	
</div>

	<script type="text/javascript">
	alert('관리자 로그인 확인되었습니다. 관리자 페이지로 이동합니다.');
	$(document).ready(function(){
		$('#btn_1').click(function(){
			console.log('button clicked');
			
			location = '../main/inquery-admin';
		}); // end btn_1 click
	}); // end document
	
	</script>

</body>
</html>